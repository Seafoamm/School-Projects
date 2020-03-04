namespace CheckingAccount
{
    partial class frmCheckingAccount
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
            this.txtTransaction = new System.Windows.Forms.TextBox();
            this.txtDate = new System.Windows.Forms.TextBox();
            this.btnCalculate = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.btnReset = new System.Windows.Forms.Button();
            this.lblTransaction = new System.Windows.Forms.Label();
            this.lblDate = new System.Windows.Forms.Label();
            this.grpTransactionType = new System.Windows.Forms.GroupBox();
            this.rbServiceFee = new System.Windows.Forms.RadioButton();
            this.rbWithdrawal = new System.Windows.Forms.RadioButton();
            this.rbDeposit = new System.Windows.Forms.RadioButton();
            this.btnReceipt = new System.Windows.Forms.Button();
            this.chkCleared = new System.Windows.Forms.CheckBox();
            this.lblBalance = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.grpTransactionType.SuspendLayout();
            this.SuspendLayout();
            // 
            // txtTransaction
            // 
            this.txtTransaction.Location = new System.Drawing.Point(150, 20);
            this.txtTransaction.Name = "txtTransaction";
            this.txtTransaction.Size = new System.Drawing.Size(100, 20);
            this.txtTransaction.TabIndex = 0;
            // 
            // txtDate
            // 
            this.txtDate.Location = new System.Drawing.Point(150, 53);
            this.txtDate.Name = "txtDate";
            this.txtDate.Size = new System.Drawing.Size(100, 20);
            this.txtDate.TabIndex = 2;
            // 
            // btnCalculate
            // 
            this.btnCalculate.Location = new System.Drawing.Point(12, 119);
            this.btnCalculate.Name = "btnCalculate";
            this.btnCalculate.Size = new System.Drawing.Size(192, 40);
            this.btnCalculate.TabIndex = 4;
            this.btnCalculate.Text = "&Calculate";
            this.btnCalculate.UseVisualStyleBackColor = true;
            this.btnCalculate.Click += new System.EventHandler(this.btnCalculate_Click);
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(12, 174);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(192, 30);
            this.btnClear.TabIndex = 5;
            this.btnClear.Text = "Cle&ar";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(12, 210);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(461, 30);
            this.btnExit.TabIndex = 6;
            this.btnExit.Text = "E&xit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // btnReset
            // 
            this.btnReset.Location = new System.Drawing.Point(281, 174);
            this.btnReset.Name = "btnReset";
            this.btnReset.Size = new System.Drawing.Size(192, 30);
            this.btnReset.TabIndex = 7;
            this.btnReset.Text = "&Reset";
            this.btnReset.UseVisualStyleBackColor = true;
            this.btnReset.Click += new System.EventHandler(this.btnReset_Click);
            // 
            // lblTransaction
            // 
            this.lblTransaction.AutoSize = true;
            this.lblTransaction.Location = new System.Drawing.Point(15, 23);
            this.lblTransaction.Name = "lblTransaction";
            this.lblTransaction.Size = new System.Drawing.Size(105, 13);
            this.lblTransaction.TabIndex = 8;
            this.lblTransaction.Text = "Transaction Amount:";
            // 
            // lblDate
            // 
            this.lblDate.AutoSize = true;
            this.lblDate.Location = new System.Drawing.Point(15, 58);
            this.lblDate.Name = "lblDate";
            this.lblDate.Size = new System.Drawing.Size(92, 13);
            this.lblDate.TabIndex = 10;
            this.lblDate.Text = "Transaction Date:";
            // 
            // grpTransactionType
            // 
            this.grpTransactionType.Controls.Add(this.rbServiceFee);
            this.grpTransactionType.Controls.Add(this.rbWithdrawal);
            this.grpTransactionType.Controls.Add(this.rbDeposit);
            this.grpTransactionType.Location = new System.Drawing.Point(281, 12);
            this.grpTransactionType.Name = "grpTransactionType";
            this.grpTransactionType.Size = new System.Drawing.Size(106, 90);
            this.grpTransactionType.TabIndex = 11;
            this.grpTransactionType.TabStop = false;
            this.grpTransactionType.Text = "Transaction Type";
            // 
            // rbServiceFee
            // 
            this.rbServiceFee.AutoSize = true;
            this.rbServiceFee.Location = new System.Drawing.Point(7, 67);
            this.rbServiceFee.Name = "rbServiceFee";
            this.rbServiceFee.Size = new System.Drawing.Size(82, 17);
            this.rbServiceFee.TabIndex = 2;
            this.rbServiceFee.TabStop = true;
            this.rbServiceFee.Text = "Service Fee";
            this.rbServiceFee.UseVisualStyleBackColor = true;
            this.rbServiceFee.CheckedChanged += new System.EventHandler(this.ReadRadioButton);
            // 
            // rbWithdrawal
            // 
            this.rbWithdrawal.AutoSize = true;
            this.rbWithdrawal.Location = new System.Drawing.Point(7, 44);
            this.rbWithdrawal.Name = "rbWithdrawal";
            this.rbWithdrawal.Size = new System.Drawing.Size(78, 17);
            this.rbWithdrawal.TabIndex = 1;
            this.rbWithdrawal.TabStop = true;
            this.rbWithdrawal.Text = "Withdrawal";
            this.rbWithdrawal.UseVisualStyleBackColor = true;
            this.rbWithdrawal.CheckedChanged += new System.EventHandler(this.ReadRadioButton);
            // 
            // rbDeposit
            // 
            this.rbDeposit.AutoSize = true;
            this.rbDeposit.Location = new System.Drawing.Point(7, 20);
            this.rbDeposit.Name = "rbDeposit";
            this.rbDeposit.Size = new System.Drawing.Size(61, 17);
            this.rbDeposit.TabIndex = 0;
            this.rbDeposit.TabStop = true;
            this.rbDeposit.Text = "Deposit";
            this.rbDeposit.UseVisualStyleBackColor = true;
            this.rbDeposit.CheckedChanged += new System.EventHandler(this.ReadRadioButton);
            // 
            // btnReceipt
            // 
            this.btnReceipt.Location = new System.Drawing.Point(281, 119);
            this.btnReceipt.Name = "btnReceipt";
            this.btnReceipt.Size = new System.Drawing.Size(192, 40);
            this.btnReceipt.TabIndex = 12;
            this.btnReceipt.Text = "R&eceipt";
            this.btnReceipt.UseVisualStyleBackColor = true;
            this.btnReceipt.Click += new System.EventHandler(this.btnReceipt_Click);
            // 
            // chkCleared
            // 
            this.chkCleared.AutoSize = true;
            this.chkCleared.Location = new System.Drawing.Point(405, 19);
            this.chkCleared.Name = "chkCleared";
            this.chkCleared.Size = new System.Drawing.Size(68, 17);
            this.chkCleared.TabIndex = 13;
            this.chkCleared.Text = "Cleared?";
            this.chkCleared.UseVisualStyleBackColor = true;
            // 
            // lblBalance
            // 
            this.lblBalance.AutoSize = true;
            this.lblBalance.Location = new System.Drawing.Point(147, 89);
            this.lblBalance.Name = "lblBalance";
            this.lblBalance.Size = new System.Drawing.Size(35, 13);
            this.lblBalance.TabIndex = 14;
            this.lblBalance.Text = "label1";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(15, 89);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(80, 13);
            this.label2.TabIndex = 15;
            this.label2.Text = "Bank Balance: ";
            // 
            // frmCheckingAccount
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(488, 252);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lblBalance);
            this.Controls.Add(this.chkCleared);
            this.Controls.Add(this.btnReceipt);
            this.Controls.Add(this.grpTransactionType);
            this.Controls.Add(this.lblDate);
            this.Controls.Add(this.lblTransaction);
            this.Controls.Add(this.btnReset);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnCalculate);
            this.Controls.Add(this.txtDate);
            this.Controls.Add(this.txtTransaction);
            this.Name = "frmCheckingAccount";
            this.Text = "Checking Account";
            this.Load += new System.EventHandler(this.frmCheckingAccount_Load);
            this.grpTransactionType.ResumeLayout(false);
            this.grpTransactionType.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtTransaction;
        private System.Windows.Forms.TextBox txtDate;
        private System.Windows.Forms.Button btnCalculate;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Button btnReset;
        private System.Windows.Forms.Label lblTransaction;
        private System.Windows.Forms.Label lblDate;
        private System.Windows.Forms.GroupBox grpTransactionType;
        private System.Windows.Forms.RadioButton rbServiceFee;
        private System.Windows.Forms.RadioButton rbWithdrawal;
        private System.Windows.Forms.RadioButton rbDeposit;
        private System.Windows.Forms.Button btnReceipt;
        private System.Windows.Forms.CheckBox chkCleared;
        private System.Windows.Forms.Label lblBalance;
        private System.Windows.Forms.Label label2;
    }
}

