using CheckingAccountClasses;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CheckingAccountFiles
{
    public partial class frmCheckingAccountFiles : Form
    {
        public frmCheckingAccountFiles()
        {
            InitializeComponent();
        }
        //make an instance of the transactions list
        Transactions transactionList = new Transactions();

        private void btnAdd_Click(object sender, EventArgs e)
        {
            //set the type based on the radio button
            string transactionType = GetTransType();
            //if all data is valid
            if (IsPresent(txtTransactionAmount) && IsPresent(txtTransactionDate) && IsValidPayee(txtPayee, transactionType) && IsValidDate(txtTransactionDate))
            {
                //if the transaction type is not withdrawal
                if (transactionType != "Withdrawal")
                {
                    //make a new transaction with the information in the textboxes and set the payee to the transaction type
                    Transaction newTrans = new Transaction(decimal.Parse(txtTransactionAmount.Text), transactionType, DateTime.Parse(txtTransactionDate.Text));
                    newTrans.Payee = newTrans.TransactionType;
                    newTrans.CheckNumber = txtCheckNumber.Text;
                    //add transaction to the list
                    transactionList.Add(newTrans);
                    //add transaction to the listbox
                    lstTransactions.Items.Add(newTrans);
                    //if the account is overdrawn, display a message box notifying the user that it is so
                    if (transactionList.OverdrawnStatus == true)
                    {
                        MessageBox.Show("Your account is overdrawn right now!");
                    }
                    //update the balance label
                    lblBalance.Text = transactionList.AccountBalance.ToString("c");
                }
                else
                {
                    //make a new transaction with the info in textboxes, including payee
                    Transaction newTrans = new Transaction(decimal.Parse(txtTransactionAmount.Text), transactionType, DateTime.Parse(txtTransactionDate.Text), txtPayee.Text);
                    //set checknumber
                    newTrans.CheckNumber = txtCheckNumber.Text;
                    //add to list
                    transactionList.Add(newTrans);
                    //add to listbox
                    lstTransactions.Items.Add(newTrans);
                    //if the account is overdrawn, display a message box notifying the user that it is so
                    if (transactionList.OverdrawnStatus == true)
                    {
                        MessageBox.Show("Your account is overdrawn right now!");
                    }
                    //update the balance
                    lblBalance.Text = transactionList.AccountBalance.ToString("c");
                }
            }

        }
        //removes the transaction at the selected index and updates balance
        private void btnRemove_Click(object sender, EventArgs e)
        {
            int index = lstTransactions.SelectedIndex;
            transactionList.RemoveAt(index);
            lstTransactions.Items.RemoveAt(index);
            lblBalance.Text = transactionList.AccountBalance.ToString("c");
        }
        //sets textboxes to blank and transaction type radio button checked to withdrawal
        private void btnClear_Click(object sender, EventArgs e)
        {
            ShowValues("", "", "", "", "Withdrawal");
        }
        //closes the application
        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
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
                txtTransactionDate.Text = transactionList[index].TransactionDate.ToShortDateString();
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

            }
        }

        private void frmCheckingAccountFiles_Load(object sender, EventArgs e)
        {
            //check the withdrawal radio button when form loads
            rbWithdrawal.Checked = true;
            //set the path for reading from and writing to
            transactionList.FileName = @"C:\Users\Brandon\Desktop\rs\visualstudioprojects\projects\CheckingAccountFiles\CheckingAccountFiles\accountfile.txt";
            //set the list to contain the info in the file
            transactionList = transactionList.FileOpen();
            //fill the listbox with the info in the file
            foreach(Transaction transaction in transactionList)
            {
                lstTransactions.Items.Add(transaction);
            }

        }

        private void frmCheckingAccountFiles_FormClosed(object sender, FormClosedEventArgs e)
        {
            //write to the file when the form closes
            transactionList.FileSave(transactionList);
        }

        //sets the values of the textboxes to arguments
        public void ShowValues(string amount, string date, string payee, string chknum, string type)
        {
            txtTransactionAmount.Text = amount;
            txtTransactionDate.Text = date;
            txtPayee.Text = payee;
            txtCheckNumber.Text = chknum;
            switch (type)
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
                default:
                    throw new ApplicationException("Not a valid transaction type");
            }
        }

        //returns the transaction type based on which radio button is checked
        public string GetTransType()
        {
            if (rbDeposit.Checked == true)
            {
                return "Deposit";
            }
            if (rbWithdrawal.Checked == true)
            {
                return "Withdrawal";
            }
            else 
            {
                return "Service Fee";
            }
        }

        //if the textbox is not empty return true
        public bool IsPresent(TextBox txt)
        {
            if (txt.Text == "")
            {
                MessageBox.Show(txt.Tag + " is required");
                return false;
            }
            return true;
        }
        //if the textbox entry is a positive decimal return true
        public bool IsValidDecimal(TextBox txt)
        {
            if (decimal.TryParse(txt.Text, out decimal amount) == false | amount <= 0)
            {
                MessageBox.Show(txt.Tag + " needs to be a positive decimal amount");
                return false;
            }
            return true;
        }
        //if the textbox entry is a valid date on or before today return true
        public bool IsValidDate(TextBox txt)
        {
            if (DateTime.TryParse(txt.Text, out DateTime date) == false | date > DateTime.Today)
            {
                MessageBox.Show(txt.Tag + " needs to be a valid date time on or before today");
                return false;
            }
            return true;
        }
        //if the transaction type is withdrawal and payee is blank return false and show a message, otherwise return true
        public bool IsValidPayee(TextBox txt, string type)
        {
            if (txt.Text == "" && type == "Withdrawal")
            {
                MessageBox.Show("Payee must be filled out");
                return false;
            }
            return true;
        }
    }
}
