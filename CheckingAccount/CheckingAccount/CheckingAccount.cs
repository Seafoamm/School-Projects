using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

//Brandon Lu Homework 2 11/13/2019
namespace CheckingAccount
{
    public partial class frmCheckingAccount : Form
    {
        public frmCheckingAccount()
        {
            InitializeComponent();
        }

        //declaring constants and variables for use in methods
        decimal bankBalance = 0;
        const string DEPOSIT_TYPE = "Deposit";
        const string WITHDRAWAL_TYPE = "Withdrawal";
        const string SERVICE_FEE_TYPE = "Service Fee";
        string transactionType = "";
        decimal balance = 0;
        string message = "";
        string cleared = "";

        //set the balance label to 0 when the form loads and set radio button tags
        private void frmCheckingAccount_Load(object sender, EventArgs e)
        {
            lblBalance.Text = bankBalance.ToString("c");

            rbDeposit.Tag = "Deposit";
            rbServiceFee.Tag = "Service fee";
            rbWithdrawal.Tag = "Withdrawal";
            
        }

        //calculate button
        private void btnCalculate_Click(object sender, EventArgs e)
        {
            

            //take the user input for transaction and check if valid
            decimal transactionAmount = IsTransactionValid(txtTransaction.Text);

            //take user input for date and check if valid
            DateTime transactionDate = IsDateValid(txtDate.Text);

            //if the date is valid then do the calculations
            if (IsTransactionPositive(transactionAmount) && IsDateBeforeToday(transactionDate))
            {
                //take the transaction type from the text box and check for validity
                transactionType = TransactionType(transactionType);

                //perform balance transactions and check for sufficient funds if cleared
                if (chkCleared.Checked == true)
                {
                    bankBalance = BankTransactionCalculation(transactionType, bankBalance, transactionAmount);
                }
                //balance calculation regardless of cleared or not
                balance = BalanceTransactionCalculation(transactionType, balance, transactionAmount);

                //display new balance on form
                lblBalance.Text = bankBalance.ToString("c");

                //read cleared? checked state
                if (chkCleared.Checked)
                {
                    cleared = "true";
                }
                else
                {
                    cleared = "false";
                }

                message = message + "Type: " + transactionType + "\n" + "Date: " + transactionDate.ToString("d") + "\n" + "Amount: " + transactionAmount.ToString() + "\n" +
                    "Cleared? " + cleared + "\n" + "Balance: " + balance.ToString() + "\n" + "Bank Balance: " + bankBalance.ToString() + "\n" + "\n";
            }

            //if the transaction amount is not positive show this message
            else if (IsTransactionPositive(transactionAmount) == false)
            {
                MessageBox.Show("Please enter a positive decimal number for transaction amount", "Invalid Transaction Amount");
                txtTransaction.Focus();
            }

            //if the date is after today then show this message
            else if (IsDateBeforeToday(transactionDate) == false)
            {
                MessageBox.Show("Please enter a date before today", "Invalid Date");
                txtDate.Focus();
            }

        }

        //show the message built when receipt is clicked
        private void btnReceipt_Click(object sender, EventArgs e)
        {
            MessageBox.Show(message);

        }

        //for bank balance
        private decimal BankTransactionCalculation(string transaction, decimal balance, decimal transactionAmount)
        {
            //variable to store the new balance in
            decimal result = 0;

            switch (transaction)
            {
                //if user types "deposit" add to the balance
                case DEPOSIT_TYPE:
                    result = balance + transactionAmount;
                    break;
                //if the user types "withdrawal" or "service fee" subtract from the balance
                case WITHDRAWAL_TYPE:
                case SERVICE_FEE_TYPE:
                    if (transactionAmount < balance)
                    {
                        result = balance - transactionAmount;
                    }
                //if the amount they are trying to subtract is more than the current balance, then don't change the balance and display message
                    else
                    {
                        MessageBox.Show("Sorry, we could not process your transaction because your account funds are insufficient", "Account Balance Insufficient");
                        result = balance + 0;
                        txtTransaction.Focus();
                    }
                    break;
                //if the user types anything other than a valid type, the TransactionType() method will return "bad" and display a message and the balance won't change
                case "":
                    result = balance + 0;
                    break;

            }
            
            return result;
        }

        //for balance even if not cleared
        private decimal BalanceTransactionCalculation(string transaction, decimal balance, decimal transactionAmount)
        {
            //variable to store the new balance in
            decimal result = 0;

            switch (transaction)
            {
                //if user types "deposit" add to the balance
                case DEPOSIT_TYPE:
                    result = balance + transactionAmount;
                    break;
                //if the user types "withdrawal" or "service fee" subtract from the balance
                case WITHDRAWAL_TYPE:
                case SERVICE_FEE_TYPE:
                        result = balance - transactionAmount;
                    break;
                //if the user types anything other than a valid type, the TransactionType() method will return "bad" and display a message and the balance won't change
                case "":
                    result = balance + 0;
                    break;

            }

            return result;
        }

        //reads which radio button is checked and sets the transaction type to the text of it
        private void ReadRadioButton(object sender, EventArgs e)
        {
            RadioButton rb = (RadioButton) sender;
            if (rb.Checked)
            {
                transactionType = (string) rb.Tag;
            }

        }

        //determine what type of transaction they type
        private string TransactionType(string text)
        {

            //takes the user input and turns it to uppercase in order to eliminate possible errors
            switch (text.ToUpper())
            {
                case "DEPOSIT":
                    text = DEPOSIT_TYPE;
                    break;
                case "WITHDRAWAL":
                    text = WITHDRAWAL_TYPE;
                    break;
                case "SERVICE FEE":
                    text = SERVICE_FEE_TYPE;
                    break;
                //if the input is not recognized, error message is displayed and "bad" is passed on to the calculation method
                default:
                    MessageBox.Show("Please select a type of transaction", "Invalid Transaction Type");
                    grpTransactionType.Focus();
                    text = "";
                    break;
            }
            return text;
        }

        //tries to parse the transaction amount the user types in, if it does not work then it returns an invalid transaction amount which causes the error message to be displayed
        private decimal IsTransactionValid (string transaction)
        {
            decimal convertedAmount;
            if(Decimal.TryParse(transaction, out convertedAmount))
            {
                return convertedAmount;
            }
            else
            {
                return -1;
            }

        }

        //tests if the transaction is positive
        private bool IsTransactionPositive (decimal transactionAmount)
        {
            if (transactionAmount > 0)
            {
                return true;
            }

            return false;
        }

        //tests if the date typed in is valid; shows error message if not
        private DateTime IsDateValid (string date)
        {
            if (DateTime.TryParse(date, out DateTime result))
            {

            }
            else
            {
                MessageBox.Show("Please enter a valid date", "Invalid Date");
            }

            return result;
        }

        //tests if the date is before today or not
        private bool IsDateBeforeToday(DateTime date)
        {
            if (date <= DateTime.Now)
            {
                return true;
            }

            return false;
        }

        //clear button
        private void btnClear_Click(object sender, EventArgs e)
        {
            this.ClearForm();
        }

        //reset button: clears textboxes and resets balance to 0
        private void btnReset_Click(object sender, EventArgs e)
        {
            this.ClearForm();
            bankBalance = 0;
            lblBalance.Text = bankBalance.ToString("c");
        }

        //clears textboxes
        private void ClearForm()
        {
            txtTransaction.Text = "";
            txtDate.Text = "";
            rbDeposit.Checked = false;
            rbWithdrawal.Checked = false;
            rbServiceFee.Checked = false;
        }

        //exit button
        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

       
    }

}
