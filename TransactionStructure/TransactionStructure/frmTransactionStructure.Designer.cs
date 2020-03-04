namespace TransactionStructure
{
    partial class frmTransactionStructure
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.txtTransactionAmount = new System.Windows.Forms.TextBox();
            this.dateTimePicker1 = new System.Windows.Forms.DateTimePicker();
            this.txtPayee = new System.Windows.Forms.TextBox();
            this.txtCheckNumber = new System.Windows.Forms.TextBox();
            this.lblTransactionAmount = new System.Windows.Forms.Label();
            this.lblTransactionDate = new System.Windows.Forms.Label();
            this.cbTransactionType = new System.Windows.Forms.ComboBox();
            this.lblTransactionType = new System.Windows.Forms.Label();
            this.lblPayee = new System.Windows.Forms.Label();
            this.lblCheckNumber = new System.Windows.Forms.Label();
            this.AccountBalanceLabel = new System.Windows.Forms.Label();
            this.lblAccountBalance = new System.Windows.Forms.Label();
            this.lstTransactions = new System.Windows.Forms.ListBox();
            this.btnProcess = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtTransactionAmount
            // 
            this.txtTransactionAmount.Location = new System.Drawing.Point(123, 12);
            this.txtTransactionAmount.Name = "txtTransactionAmount";
            this.txtTransactionAmount.Size = new System.Drawing.Size(100, 20);
            this.txtTransactionAmount.TabIndex = 0;
            // 
            // dateTimePicker1
            // 
            this.dateTimePicker1.Location = new System.Drawing.Point(352, 12);
            this.dateTimePicker1.Name = "dateTimePicker1";
            this.dateTimePicker1.Size = new System.Drawing.Size(200, 20);
            this.dateTimePicker1.TabIndex = 1;
            // 
            // txtPayee
            // 
            this.txtPayee.Location = new System.Drawing.Point(123, 78);
            this.txtPayee.Name = "txtPayee";
            this.txtPayee.Size = new System.Drawing.Size(100, 20);
            this.txtPayee.TabIndex = 3;
            // 
            // txtCheckNumber
            // 
            this.txtCheckNumber.Location = new System.Drawing.Point(123, 112);
            this.txtCheckNumber.Name = "txtCheckNumber";
            this.txtCheckNumber.Size = new System.Drawing.Size(100, 20);
            this.txtCheckNumber.TabIndex = 4;
            // 
            // lblTransactionAmount
            // 
            this.lblTransactionAmount.AutoSize = true;
            this.lblTransactionAmount.Location = new System.Drawing.Point(12, 15);
            this.lblTransactionAmount.Name = "lblTransactionAmount";
            this.lblTransactionAmount.Size = new System.Drawing.Size(105, 13);
            this.lblTransactionAmount.TabIndex = 5;
            this.lblTransactionAmount.Text = "Transaction Amount:";
            // 
            // lblTransactionDate
            // 
            this.lblTransactionDate.AutoSize = true;
            this.lblTransactionDate.Location = new System.Drawing.Point(254, 15);
            this.lblTransactionDate.Name = "lblTransactionDate";
            this.lblTransactionDate.Size = new System.Drawing.Size(92, 13);
            this.lblTransactionDate.TabIndex = 6;
            this.lblTransactionDate.Text = "Transaction Date:";
            // 
            // cbTransactionType
            // 
            this.cbTransactionType.FormattingEnabled = true;
            this.cbTransactionType.Location = new System.Drawing.Point(123, 45);
            this.cbTransactionType.Name = "cbTransactionType";
            this.cbTransactionType.Size = new System.Drawing.Size(121, 21);
            this.cbTransactionType.TabIndex = 7;
            // 
            // lblTransactionType
            // 
            this.lblTransactionType.AutoSize = true;
            this.lblTransactionType.Location = new System.Drawing.Point(12, 48);
            this.lblTransactionType.Name = "lblTransactionType";
            this.lblTransactionType.Size = new System.Drawing.Size(93, 13);
            this.lblTransactionType.TabIndex = 8;
            this.lblTransactionType.Text = "Transaction Type:";
            // 
            // lblPayee
            // 
            this.lblPayee.AutoSize = true;
            this.lblPayee.Location = new System.Drawing.Point(13, 81);
            this.lblPayee.Name = "lblPayee";
            this.lblPayee.Size = new System.Drawing.Size(40, 13);
            this.lblPayee.TabIndex = 9;
            this.lblPayee.Text = "Payee:";
            // 
            // lblCheckNumber
            // 
            this.lblCheckNumber.AutoSize = true;
            this.lblCheckNumber.Location = new System.Drawing.Point(13, 115);
            this.lblCheckNumber.Name = "lblCheckNumber";
            this.lblCheckNumber.Size = new System.Drawing.Size(81, 13);
            this.lblCheckNumber.TabIndex = 10;
            this.lblCheckNumber.Text = "Check Number:";
            // 
            // AccountBalanceLabel
            // 
            this.AccountBalanceLabel.AutoSize = true;
            this.AccountBalanceLabel.Location = new System.Drawing.Point(13, 154);
            this.AccountBalanceLabel.Name = "AccountBalanceLabel";
            this.AccountBalanceLabel.Size = new System.Drawing.Size(92, 13);
            this.AccountBalanceLabel.TabIndex = 11;
            this.AccountBalanceLabel.Text = "Account Balance:";
            // 
            // lblAccountBalance
            // 
            this.lblAccountBalance.AutoSize = true;
            this.lblAccountBalance.Location = new System.Drawing.Point(120, 154);
            this.lblAccountBalance.Name = "lblAccountBalance";
            this.lblAccountBalance.Size = new System.Drawing.Size(84, 13);
            this.lblAccountBalance.TabIndex = 12;
            this.lblAccountBalance.Text = "accountbalance";
            // 
            // lstTransactions
            // 
            this.lstTransactions.FormattingEnabled = true;
            this.lstTransactions.Location = new System.Drawing.Point(257, 45);
            this.lstTransactions.Name = "lstTransactions";
            this.lstTransactions.Size = new System.Drawing.Size(295, 134);
            this.lstTransactions.TabIndex = 13;
            this.lstTransactions.SelectedIndexChanged += new System.EventHandler(this.lstTransactions_SelectedIndexChanged);
            // 
            // btnProcess
            // 
            this.btnProcess.Location = new System.Drawing.Point(15, 194);
            this.btnProcess.Name = "btnProcess";
            this.btnProcess.Size = new System.Drawing.Size(75, 23);
            this.btnProcess.TabIndex = 14;
            this.btnProcess.Text = "&Process";
            this.btnProcess.UseVisualStyleBackColor = true;
            this.btnProcess.Click += new System.EventHandler(this.btnProcess_Click);
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(143, 194);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(75, 23);
            this.btnClear.TabIndex = 15;
            this.btnClear.Text = "&Clear";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(395, 194);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 23);
            this.btnExit.TabIndex = 17;
            this.btnExit.Text = "E&xit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // frmTransactionStructure
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(574, 244);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnProcess);
            this.Controls.Add(this.lstTransactions);
            this.Controls.Add(this.lblAccountBalance);
            this.Controls.Add(this.AccountBalanceLabel);
            this.Controls.Add(this.lblCheckNumber);
            this.Controls.Add(this.lblPayee);
            this.Controls.Add(this.lblTransactionType);
            this.Controls.Add(this.cbTransactionType);
            this.Controls.Add(this.lblTransactionDate);
            this.Controls.Add(this.lblTransactionAmount);
            this.Controls.Add(this.txtCheckNumber);
            this.Controls.Add(this.txtPayee);
            this.Controls.Add(this.dateTimePicker1);
            this.Controls.Add(this.txtTransactionAmount);
            this.Name = "frmTransactionStructure";
            this.Text = "TransactionStructure";
            this.Load += new System.EventHandler(this.frmTransactionStructure_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtTransactionAmount;
        private System.Windows.Forms.DateTimePicker dateTimePicker1;
        private System.Windows.Forms.TextBox txtPayee;
        private System.Windows.Forms.TextBox txtCheckNumber;
        private System.Windows.Forms.Label lblTransactionAmount;
        private System.Windows.Forms.Label lblTransactionDate;
        private System.Windows.Forms.ComboBox cbTransactionType;
        private System.Windows.Forms.Label lblTransactionType;
        private System.Windows.Forms.Label lblPayee;
        private System.Windows.Forms.Label lblCheckNumber;
        private System.Windows.Forms.Label AccountBalanceLabel;
        private System.Windows.Forms.Label lblAccountBalance;
        private System.Windows.Forms.ListBox lstTransactions;
        private System.Windows.Forms.Button btnProcess;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnExit;
    }
}

