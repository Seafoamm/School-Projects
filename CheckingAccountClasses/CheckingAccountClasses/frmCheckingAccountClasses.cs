using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
//Brandon Lu Homework 6 2/27/19
namespace CheckingAccountClasses
{
    public partial class frmCheckingAccountClasses : Form
    {
        public frmCheckingAccountClasses()
        {
            InitializeComponent();
        }
        //initialize balance and list for storing transactions
        decimal balance = 0;
        List<Transaction> transactionList = new List<Transaction>();
       
        //set default date value and default transaction type selection; set balance to empty
        private void frmCheckingAccountClasses_Load(object sender, EventArgs e)
        {
            dtpTransactionDate.Value = DateTime.Today;
            rbDeposit.Checked = true;
            lblBalance.Text = "";
        }

        private void lstTransactions_SelectedIndexChanged(object sender, EventArgs e)
        {
            //index of the list item to be manipulated is the index of the selected item in the list box
            int index = lstTransactions.SelectedIndex;
            //if there's something selected...
            if (lstTransactions.SelectedIndex != -1)
            {
                //display information from list item to form for appropriate controls
                txtTransactionAmount.Text = transactionList[index].TransactionAmount.ToString();
                txtCheckNumber.Text = transactionList[index].CheckNumber;
                txtPayee.Text = transactionList[index].Payee;
                switch (transactionList[index].TransactionType)
                {
                    case "Deposit":
                        rbDeposit.Checked = true;
                        break;
                    case "Withdrawal":
                        rbWithdrawal.Checked = true;
                        break;
                    case "Service Fee":
                        rbServiceFee.Checked = true;
                        break;
                }
                dtpTransactionDate.Value = transactionList[index].TransactionDate;

            }
        }

 

        private void btnProcess_Click(object sender, EventArgs e)
        {
            //get the transaction type from the radio buttons
            string transactionType = DetermineTransactionType();
            //if all required data is present and if the payee is valid...
            if (Transaction.IsPresent(txtTransactionAmount) && Transaction.IsPositive(decimal.Parse(txtTransactionAmount.Text)) && Transaction.IsDecimal(txtTransactionAmount.Text) && Transaction.IsValidPayee(txtPayee.Text, transactionType, txtPayee))
            {
                //make a new instance of transaction class with values in textboxes to construct it
                Transaction newTransaction = new Transaction(decimal.Parse(txtTransactionAmount.Text), transactionType, dtpTransactionDate.Value);
                //add the payee in (separate because is optional)
                newTransaction.Payee = txtPayee.Text;
                //if there is a check number entered, set the new transaction's check number
                if (txtCheckNumber.Text != "")
                {
                    
                        newTransaction.CheckNumber = txtCheckNumber.Text;
                    
                }
                //calculate the balance based on the type of transaction and amount
                CalculateBalance(newTransaction.TransactionAmount, newTransaction.TransactionType);

                //add the transaction to the listbox and the list
                transactionList.Add(newTransaction);
                lstTransactions.Items.Add(newTransaction);
            }

        }

        private void btnRemove_Click(object sender, EventArgs e)
        {
            //remove the item from the list box and the list based on the selected index of the listbox
            int index = lstTransactions.SelectedIndex;
            transactionList.RemoveAt(index);
            lstTransactions.Items.RemoveAt(index);
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            //display these default/empty values to the textboxes
            ShowInfo("", "", DateTime.Today, "", "");
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void CalculateBalance(decimal amount, string type)
        {
            //if the transaction type is not deposit then make it negative
            if (type != "Deposit")
            {
                 amount *= -1;
            }
            //add to the balance
            balance += amount;

            //if you are trying to take funds from an account that would make it negative, show a warning
            if(balance < 0 && type != "Deposit")
            {
                MessageBox.Show("Your account balance is less than zero!", "Negative Balance");
            }
            //update balance on the form
            lblBalance.Text = balance.ToString("c");
        }

        //show info based on input
        private void ShowInfo(string amount, string type, DateTime date, string payee, string chknum)
        {
            txtTransactionAmount.Text = amount;
            dtpTransactionDate.Value = date;
            txtPayee.Text = payee;
            txtCheckNumber.Text = chknum;
        }
        //show info based on input
        private void ShowInfo(string amount, string type, DateTime date, string payee, string chknum, RadioButton rb)
        {
            txtTransactionAmount.Text = amount;

            if ((string)rb.Tag == type)
            {
                rb.Checked = true;
            }

            dtpTransactionDate.Value = date;
            txtPayee.Text = payee;
            txtCheckNumber.Text = chknum;
        }
        //return a transaction type based on which radio button is checked
        public string DetermineTransactionType()
        {
               if (rbDeposit.Checked == true)
            {
                return "Deposit";
            }
               if (rbWithdrawal.Checked == true)
            {
                return "Withdrawal";
            }
            if (rbServiceFee.Checked == true)
            {
                return "Service Fee";
            }
            //if there is none selected somehow, crash the application because that's not supposed to be possible
            else
                throw new ApplicationException("You must have a transaction type selected");
         
        }

    }
}
