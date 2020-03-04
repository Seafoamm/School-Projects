using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Transaction3
{
    public partial class frmCheckingAccount : Form
    {
        public frmCheckingAccount()
        {
            InitializeComponent();
        }
        //keep track of columns in array
        enum Columns
        {
            transactionamount,
            transactiondate,
            transactiontype
        }
        //class level balance declarations
        decimal balance = 0m;
        decimal bankBalance = 0m;

        //declare string for adding to listbox
        string[,] transactions = new string[99, 4];

        
        //when listbox selected index is changed
        private void lbTransactions_SelectedIndexChanged(object sender, EventArgs e)
        {
            int selected = lbTransactions.SelectedIndex;

            //display info to textboxes based on selected index
            txtTransactionAmount.Text = transactions[selected, (int)Columns.transactionamount];
            txtTransactionDate.Text = transactions[selected, (int)Columns.transactiondate];
            cbTransactionType.Text = transactions[selected, (int)Columns.transactiontype];
        
        }

        //when transactiontype combobox is changed 
        private void cbTransactionType_SelectionChangeCommitted(object sender, EventArgs e)
        {
            string transactionType = cbTransactionType.Text;
            //set transactiontype to combobox selection
        }

        //add button
        private void btnAdd_Click(object sender, EventArgs e)
        {
            //synchronize array with listbox count
            int selected = lbTransactions.Items.Count;

            //do calculations if everything is valid
            if (DataIsValid())
            {
                decimal transactionAmount = Decimal.Parse(txtTransactionAmount.Text);
                DateTime transactionDate = DateTime.Parse(txtTransactionDate.Text);
                string transactionType = cbTransactionType.Text;

                //determine and calculate transactiontype and transaction based on transaction type
                transactionAmount = CheckTransactionType(transactionAmount, transactionType);

                //only change balance when processed is checked
                if (chkProcessed.Checked)
                {
                    balance += transactionAmount;
                }

                bankBalance += transactionAmount;

                //add data to transactions array
                AddToTransactions(selected, transactionAmount, transactionDate, transactionType);
                
            }

        }

        //update button; displays updated balances
        private void btnUpdate_Click(object sender, EventArgs e)
        {
            ShowBalances();
        }

        //clear button; clears text boxes and listbox
        private void btnClear_Click(object sender, EventArgs e)
        {
            ShowValues("","");
            lbTransactions.Items.Clear();
            DefaultSettings();

        }

        //clears everything and also resets balances
        private void btnReset_Click(object sender, EventArgs e)
        {
            ResetBalances();
            ShowBalances();
            ShowValues("","");
            lbTransactions.Items.Clear();
            DefaultSettings();

        }

        //set everything to zero and clear, add choices to combobox
        private void frmCheckingAccount_Load(object sender, EventArgs e)
        {
            ShowBalances();
            DefaultSettings();
          
            cbTransactionType.Items.Add("Deposit");
            cbTransactionType.Items.Add("Withdrawal");
            cbTransactionType.Items.Add("Service Fee");
        }

        //menu exit
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        //determine if date is before today
        private bool IsValidDate(DateTime input)
        {
            if (input > DateTime.Now)
            {
                return false;
            }
            return true;
        }

        //determine if the transaction is valid
        private bool HaveSufficientFunds(decimal balance, decimal transactionAmt, string a)
        {
            //if you are adding or subtracting less than the balance or equal to it's fine
            if (balance >= transactionAmt)
            {
                return true;
            }
            //you can add more than your balance or subtract more if it's deposit or service fee
            if (balance < transactionAmt && a != "Withdrawal")
            {
                return true;
            }

            return false;
            
        }

        //check if data is valid: date, transaction, and sufficient funds
        private bool DataIsValid()
        {
            decimal result;
            Decimal.TryParse(txtTransactionAmount.Text, out result);
            DateTime transactionDate;
            string transactiontype = cbTransactionType.Text;

            //build error message
            string message = "";
            

            if (result > 0 && DateTime.TryParse(txtTransactionDate.Text, out transactionDate) && IsValidDate(transactionDate) && HaveSufficientFunds(balance, result, transactiontype))
            {
                return true;
            }
            if (result < 0)
            {
                message += "Please enter a positive transaction amount" + "\n";
            }
            if (DateTime.TryParse(txtTransactionDate.Text, out transactionDate) == false | IsValidDate(transactionDate) == false)
            {
                message += "Please enter a valid date on or before today" + "\n";
            }
            if (HaveSufficientFunds(balance, result, transactiontype) == false)
            {
                message += "You have insufficient funds" + "\n";
            }
            MessageBox.Show(message, "Error");
            return false;
        }

        //if the transaction type is not deposit, amount is subtracted
        private decimal CheckTransactionType(decimal amount, string type)
        {
            if (type != "Deposit")
            {
                amount *= -1;
            }
            return amount;
        }

        //adds to transactions array to put into combobox
        private void AddToTransactions(int selected, decimal a, DateTime b, string c)
        {
            transactions[selected, 0] = a.ToString();
            transactions[selected, 1] = b.ToString();
            transactions[selected, 2] = c.ToString();
            string entry = string.Format("{0} {1} {2}", transactions[selected, 0], transactions[selected, 1], transactions[selected, 2]);
            lbTransactions.Items.Add(entry);
        }

        //displays values to text boxes
        private void ShowValues(string a, string b)
        {
            txtTransactionAmount.Text = a;
            txtTransactionDate.Text = b;
        }

        //resets checkbox and transaction listbox
        private void DefaultSettings()
        {
            cbTransactionType.SelectedIndex = -1;
            chkProcessed.Checked = false;
        }

        //reset balances
        private void ResetBalances()
        {
            balance = 0;
            bankBalance = 0;

        }

        //display balances
        private void ShowBalances()
        {
            lblBalance.Text = balance.ToString();
            lblBankBalance.Text = bankBalance.ToString();
        }

    }
}

