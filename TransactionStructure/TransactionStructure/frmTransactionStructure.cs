using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

//Brandon Lu Homework 5 2/13/2019

namespace TransactionStructure
{
    public partial class frmTransactionStructure : Form
    {
        public struct Transaction
        {
            private string amount;
            private string type;
            private string payee;
            private string chknum;
            private string date;

            public Transaction(string transAmount, string transType, string transPayee, string transChknum, string transDate)
            {
                this.amount = transAmount;
                this.type = transType;
                this.payee = transPayee;
                this.chknum = transChknum;
                this.date = transDate;
            }

            public string TransactionAmount
            {
                get { return amount; }
                set { amount = value; }
            }

            public string TransactionType
            {
                get { return type; }
                set { type = value; }
            }

            public string TransactionPayee
            {
                get { return payee; }
                set { payee = value; }
            }

            public string TransactionCheckNumber
            {
                get { return chknum; }
                set { chknum = value; }
            }

            public string TransactionDate
            {
                get { return date; }
                set { date = value; }
            }

            public override string ToString()
            {
                return string.Format("{0} {1} {2}", amount, type, date);
            }

        }

        public frmTransactionStructure()
        {
            InitializeComponent();
        }

        private void frmTransactionStructure_Load(object sender, EventArgs e)
        {
            SetTextboxValues("", "Deposit", "", "", DateTime.Today.ToShortDateString());
            lblAccountBalance.Text = accountBalance.ToString("c");
            cbTransactionType.Items.Add("Deposit");
            cbTransactionType.Items.Add("Withdrawal");
            cbTransactionType.Items.Add("Service Fee");
        }

        enum arrayColumn
        {
            amount,
            type,
            payee,
            chknum,
            date
        }

        string[,] transactionArray = new string[4, 5];
        decimal accountBalance = 0;

        private void lstTransactions_SelectedIndexChanged(object sender, EventArgs e)
        {
            int row = lstTransactions.Items.Count -1;
            if (lstTransactions.SelectedIndex != -1)
            {
                SetTextboxValues(
                    transactionArray[row, (int)arrayColumn.amount],
                    transactionArray[row, (int)arrayColumn.type],
                    transactionArray[row, (int)arrayColumn.payee],
                    transactionArray[row, (int)arrayColumn.chknum],
                    transactionArray[row, (int)arrayColumn.date]
                    );
            }
        }

        private void btnProcess_Click(object sender, EventArgs e)
        {
            bool flag = true;
            decimal transactionAmount = IsValidTransactionAmount(txtTransactionAmount.Text);

            if (transactionAmount == -1)
            {
                flag = false;
            }

            string transactionType = cbTransactionType.Text;
            string payee = IsValidPayee(txtPayee.Text, transactionType);

            if (payee == "no")
            {
                flag = false;
            }

            string checkNumber = txtCheckNumber.Text;
            string transactionDate = dateTimePicker1.Value.ToShortDateString();

            if (flag)
            {
                accountBalance = CalculateBalance(transactionAmount, transactionType);

                if (accountBalance == -1)
                {
                    flag = false;
                }

                if (flag)
                {
                    Transaction currentTransaction;
                    currentTransaction = new Transaction(transactionAmount.ToString("c"), transactionType, payee, checkNumber, transactionDate);

                    AddToArray(currentTransaction.TransactionAmount, currentTransaction.TransactionType, currentTransaction.TransactionPayee,
                        currentTransaction.TransactionCheckNumber, currentTransaction.TransactionDate);

                    lstTransactions.Items.Add(currentTransaction);
                }
            }

           
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            SetTextboxValues("", "Deposit", "", "", DateTime.Today.ToShortDateString());
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void SetTextboxValues(string amount, string type, string payee, string checkNumber, string date)
        {
            txtTransactionAmount.Text = amount;
            cbTransactionType.Text = type;
            txtPayee.Text = payee;
            txtCheckNumber.Text = checkNumber;
            dateTimePicker1.Text = date;
        }

        private decimal IsValidTransactionAmount(string input)
        {
            if(Decimal.TryParse(input, out decimal result) == false | result <= 0)
            {
                MessageBox.Show("Please enter a positive decimal amount for the transaction amount", "Error");
                return -1;
            }

            else
            {
                return result;
            }
        }

        private string IsValidPayee(string payee, string type)
        {
           if (payee == "")
            {
                if (type == "Withdrawal")
                {
                    MessageBox.Show("Please enter the name of your payee", "Error");
                    return "no";
                }
            }

            return payee;
        }

        private decimal CalculateBalance(decimal amount, string type)
        {
            if (type != "Deposit" && amount > accountBalance)
            {
                MessageBox.Show("You do not have sufficient funds in your account", "Insufficient funds");
                return -1;
            }

            else
            {
                if (type != "Deposit")
                {
                    amount *= -1;
                }

                accountBalance += amount;
                lblAccountBalance.Text = accountBalance.ToString("c");
                return accountBalance;
            }
        }

        private void AddToArray(string amount, string type, string payee, string checkNumber, string date)
        {
            int row = lstTransactions.Items.Count;
            transactionArray[row,
            (int)arrayColumn.amount] = amount;
            transactionArray[row,
            (int)arrayColumn.type] = type;
            transactionArray[row,
            (int)arrayColumn.payee] = payee;
            transactionArray[row,
            (int)arrayColumn.chknum] = checkNumber;
            transactionArray[row,
            (int)arrayColumn.date] = date;
            
            if (transactionArray.GetUpperBound(0) == row)
            {
                btnProcess.Enabled = false;
            }
        }
    }
}
