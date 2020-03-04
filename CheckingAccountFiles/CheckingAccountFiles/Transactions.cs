using CheckingAccountClasses;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace CheckingAccountFiles
{
    class Transactions
    {
        //instantiate list of transactions
        private List<Transaction> transactions;

        //instantiate a new list when class is instantiated
        public Transactions()
        {
            transactions = new List<Transaction>();
        }
        //add method that adds the transaction to the list
        public void Add(Transaction newTransaction)
        {
            transactions.Add(newTransaction);
        }
        //remove method that removes a transaction from the list
        public void Remove(Transaction thisTransaction)
        {
            transactions.Remove(thisTransaction);
        }
        //remove method that removes the transaction at the index
        public void RemoveAt(int index)
        {
            transactions.RemoveAt(index);
        }
        //indexer that returns the transaction at the index
        public Transaction this[int index]
        {
            get
            {
                return transactions[index];
            }
            set
            {
                transactions[index] = value;
            }
        }
        //property that returns the amount of transactions in the list
        public int Count
        {
            get
            {
                return transactions.Count;
            }
        }
        //property that gets the account balance by adding all the transactions together in the list
        public decimal AccountBalance
        {
            get
            {
                decimal balance = 0;
                foreach (Transaction transaction in transactions)
                {
                    if (transaction.TransactionType == "Deposit")
                        balance += transaction.TransactionAmount;
                    else
                        balance -= transaction.TransactionAmount;
                }
                return balance;
            }
        }
        //returns true if overdrawn (balance <0)
        public bool OverdrawnStatus
        {
            get
            {
                return AccountBalance < 0;
            }
        }

        private string fileName;
        //property that contains the file path for reading and writing to 
        public string FileName
        {
            get
            {
                return fileName;
            }
            set
            {
                fileName = value;
            }
        }
        //opens the file at the file path and returns the transaction list with the info in the file
        public Transactions FileOpen()
        {
            Transactions newTransactions = new Transactions();
            newTransactions.FileName = @"C:\Users\Brandon\Desktop\rs\visualstudioprojects\projects\CheckingAccountFiles\CheckingAccountFiles\accountfile.txt";
            StreamReader streamR = new StreamReader(new FileStream(this.FileName, FileMode.OpenOrCreate, FileAccess.Read));
            while (streamR.Peek() != -1)
            {
                string line = streamR.ReadLine();
                string[] info = line.Split('|');
                Transaction thisTransaction = new Transaction(decimal.Parse(info[0]), info[1], DateTime.Parse(info[2]));

                thisTransaction.Payee = info[3];
                thisTransaction.CheckNumber = info[4];
                
          
                
                newTransactions.Add(thisTransaction);

            }
            streamR.Close();
            return newTransactions;
        }
        //from http://james-ramsden.com/implement-ienumerable-c/ to allow foreach loop for Transactions collection
        public IEnumerator GetEnumerator()
        {
            foreach (var val in transactions)
            {
                yield return val;
            }
        }
        //for each transaction in the list, write it to the file separated by '|' characters
        public void FileSave(Transactions transactions)
        {
            StreamWriter streamW = new StreamWriter(new FileStream(this.FileName, FileMode.Create, FileAccess.Write));
            foreach(Transaction transaction in transactions)
            {
                streamW.Write(transaction.TransactionAmount + "|" + transaction.TransactionType + "|" + transaction.TransactionDate.ToShortDateString() + "|" + transaction.Payee + "|" + transaction.CheckNumber);
                streamW.Write("\n");
            }
            streamW.Close();
        }
        

    }
}
