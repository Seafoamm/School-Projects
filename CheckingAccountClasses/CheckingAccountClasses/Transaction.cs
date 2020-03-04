using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
//Brandon Lu Homework 6 2/27/19
namespace CheckingAccountClasses
{
    public class Transaction
    {
        //private fields to define the transaction
        private string transactionType, payee, checkNumber;
        private decimal transactionAmount;
        private DateTime transactionDate;

        //constructor for required elements
        public Transaction(decimal transAmount, string transType, DateTime transDate)
        {
            TransactionAmount = transAmount;
            TransactionType = transType;
            TransactionDate = transDate;
        }
        //constructor for all elements
        public Transaction(decimal transAmount, string transType, DateTime transDate, string _payee, string chknum)
        {
            TransactionAmount = transAmount;
            TransactionType = transType;
            TransactionDate = transDate;
            Payee = _payee;
            CheckNumber = chknum;
        }

        //public properties to work with private fields of this class
        public string TransactionType
        {
            get
            {
                return transactionType;
            }
            set
            {
                transactionType = value;
            }
        }

        public string Payee
        {
            get
            {
                return payee;
            }
            set
            {
                payee = value;
            }
        }

        public string CheckNumber
        {
            get
            {
                return checkNumber;
            }
            set
            {
                checkNumber = value;
            }
        }

        public decimal TransactionAmount
        {
            get
            {
                return transactionAmount;
            }
            set
            {
                transactionAmount = value;
            }
        }

        public DateTime TransactionDate
        {
            get
            {
                return transactionDate;
            }
            set
            {
                transactionDate = value;
            }
        }

        //display transaction amount and type and date when converting to string
        public override string ToString()
        {
            return TransactionAmount.ToString() + " " + TransactionType + " " + TransactionDate.ToShortDateString();
        }

        //checks if there's an entry; if not, display an error message
        public static bool IsPresent(TextBox txt)
        {
            if (txt.Text == "")
            {
                MessageBox.Show(txt.Tag + " must have an entry.", "Entry Error");
                return false;
            }
            return true;
        }

        //checks if the decimal is positive
        public static bool IsPositive(decimal amount)
        {
            if (amount < 0)
            {
                MessageBox.Show("Transaction amount must be positive", "Error");
                return false;
            }
            return true;
        }
        //checks if the entry is a valid decimal amount, if not displays error message
        public static bool IsDecimal(string entry)
        {
            if (decimal.TryParse(entry, out decimal amount) == false)
            {
                MessageBox.Show("Transaction amount must be a decimal", "Error");
            }
            return decimal.TryParse(entry, out amount);
        }
        //if the transaction type is not withdrawal, the payee will be the name of the transaction type; if the payee is blank and it's withdrawal, return false and show error message
        public static bool IsValidPayee(string entry, string type, TextBox txt)
        {
            if (type != "Withdrawal")
            {
                txt.Text = type;
            }

            else if (txt.Text == "")
            {
                MessageBox.Show("Please enter a payee", "Entry Error");
                return false;
            }

            return true;
        }

    }
}
