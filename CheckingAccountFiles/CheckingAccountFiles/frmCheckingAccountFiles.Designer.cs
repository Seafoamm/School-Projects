namespace CheckingAccountFiles
{
    partial class frmCheckingAccountFiles
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
            this.lblTransactionAmount = new System.Windows.Forms.Label();
            this.lblTransactionDate = new System.Windows.Forms.Label();
            this.lblPayee = new System.Windows.Forms.Label();
            this.lblChkNum = new System.Windows.Forms.Label();
            this.grpTType = new System.Windows.Forms.GroupBox();
            this.rbServiceFee = new System.Windows.Forms.RadioButton();
            this.rbDeposit = new System.Windows.Forms.RadioButton();
            this.rbWithdrawal = new System.Windows.Forms.RadioButton();
            this.txtTransactionAmount = new System.Windows.Forms.TextBox();
            this.txtTransactionDate = new System.Windows.Forms.TextBox();
            this.txtPayee = new System.Windows.Forms.TextBox();
            this.txtCheckNumber = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.lblBalance = new System.Windows.Forms.Label();
            this.lstTransactions = new System.Windows.Forms.ListBox();
            this.btnAdd = new System.Windows.Forms.Button();
            this.btnRemove = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.grpTType.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblTransactionAmount
            // 
            this.lblTransactionAmount.AutoSize = true;
            this.lblTransactionAmount.Location = new System.Drawing.Point(12, 9);
            this.lblTransactionAmount.Name = "lblTransactionAmount";
            this.lblTransactionAmount.Size = new System.Drawing.Size(105, 13);
            this.lblTransactionAmount.TabIndex = 0;
            this.lblTransactionAmount.Text = "Transaction Amount:";
            // 
            // lblTransactionDate
            // 
            this.lblTransactionDate.AutoSize = true;
            this.lblTransactionDate.Location = new System.Drawing.Point(12, 57);
            this.lblTransactionDate.Name = "lblTransactionDate";
            this.lblTransactionDate.Size = new System.Drawing.Size(92, 13);
            this.lblTransactionDate.TabIndex = 1;
            this.lblTransactionDate.Text = "Transaction Date:";
            // 
            // lblPayee
            // 
            this.lblPayee.AutoSize = true;
            this.lblPayee.Location = new System.Drawing.Point(12, 104);
            this.lblPayee.Name = "lblPayee";
            this.lblPayee.Size = new System.Drawing.Size(40, 13);
            this.lblPayee.TabIndex = 2;
            this.lblPayee.Text = "Payee:";
            // 
            // lblChkNum
            // 
            this.lblChkNum.AutoSize = true;
            this.lblChkNum.Location = new System.Drawing.Point(12, 155);
            this.lblChkNum.Name = "lblChkNum";
            this.lblChkNum.Size = new System.Drawing.Size(81, 13);
            this.lblChkNum.TabIndex = 3;
            this.lblChkNum.Text = "Check Number:";
            // 
            // grpTType
            // 
            this.grpTType.Controls.Add(this.rbServiceFee);
            this.grpTType.Controls.Add(this.rbDeposit);
            this.grpTType.Controls.Add(this.rbWithdrawal);
            this.grpTType.Location = new System.Drawing.Point(231, 12);
            this.grpTType.Name = "grpTType";
            this.grpTType.Size = new System.Drawing.Size(200, 100);
            this.grpTType.TabIndex = 4;
            this.grpTType.TabStop = false;
            this.grpTType.Text = "Transaction Type";
            // 
            // rbServiceFee
            // 
            this.rbServiceFee.AutoSize = true;
            this.rbServiceFee.Location = new System.Drawing.Point(7, 68);
            this.rbServiceFee.Name = "rbServiceFee";
            this.rbServiceFee.Size = new System.Drawing.Size(82, 17);
            this.rbServiceFee.TabIndex = 2;
            this.rbServiceFee.TabStop = true;
            this.rbServiceFee.Tag = "Service Fee";
            this.rbServiceFee.Text = "Service Fee";
            this.rbServiceFee.UseVisualStyleBackColor = true;
            // 
            // rbDeposit
            // 
            this.rbDeposit.AutoSize = true;
            this.rbDeposit.Location = new System.Drawing.Point(7, 44);
            this.rbDeposit.Name = "rbDeposit";
            this.rbDeposit.Size = new System.Drawing.Size(61, 17);
            this.rbDeposit.TabIndex = 1;
            this.rbDeposit.TabStop = true;
            this.rbDeposit.Tag = "Deposit";
            this.rbDeposit.Text = "Deposit";
            this.rbDeposit.UseVisualStyleBackColor = true;
            // 
            // rbWithdrawal
            // 
            this.rbWithdrawal.AutoSize = true;
            this.rbWithdrawal.Location = new System.Drawing.Point(7, 20);
            this.rbWithdrawal.Name = "rbWithdrawal";
            this.rbWithdrawal.Size = new System.Drawing.Size(78, 17);
            this.rbWithdrawal.TabIndex = 0;
            this.rbWithdrawal.TabStop = true;
            this.rbWithdrawal.Tag = "Withdrawal";
            this.rbWithdrawal.Text = "Withdrawal";
            this.rbWithdrawal.UseVisualStyleBackColor = true;
            // 
            // txtTransactionAmount
            // 
            this.txtTransactionAmount.Location = new System.Drawing.Point(123, 6);
            this.txtTransactionAmount.Name = "txtTransactionAmount";
            this.txtTransactionAmount.Size = new System.Drawing.Size(100, 20);
            this.txtTransactionAmount.TabIndex = 5;
            this.txtTransactionAmount.Tag = "Transaction Amount";
            // 
            // txtTransactionDate
            // 
            this.txtTransactionDate.Location = new System.Drawing.Point(123, 54);
            this.txtTransactionDate.Name = "txtTransactionDate";
            this.txtTransactionDate.Size = new System.Drawing.Size(100, 20);
            this.txtTransactionDate.TabIndex = 6;
            this.txtTransactionDate.Tag = "Transaction Date";
            // 
            // txtPayee
            // 
            this.txtPayee.Location = new System.Drawing.Point(123, 101);
            this.txtPayee.Name = "txtPayee";
            this.txtPayee.Size = new System.Drawing.Size(100, 20);
            this.txtPayee.TabIndex = 7;
            this.txtPayee.Tag = "Payee";
            // 
            // txtCheckNumber
            // 
            this.txtCheckNumber.Location = new System.Drawing.Point(123, 149);
            this.txtCheckNumber.Name = "txtCheckNumber";
            this.txtCheckNumber.Size = new System.Drawing.Size(100, 20);
            this.txtCheckNumber.TabIndex = 8;
            this.txtCheckNumber.Tag = "Check Number";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(235, 152);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(49, 13);
            this.label5.TabIndex = 3;
            this.label5.Text = "Balance:";
            // 
            // lblBalance
            // 
            this.lblBalance.AutoSize = true;
            this.lblBalance.Location = new System.Drawing.Point(335, 152);
            this.lblBalance.Name = "lblBalance";
            this.lblBalance.Size = new System.Drawing.Size(35, 13);
            this.lblBalance.TabIndex = 4;
            this.lblBalance.Text = "label6";
            // 
            // lstTransactions
            // 
            this.lstTransactions.FormattingEnabled = true;
            this.lstTransactions.Location = new System.Drawing.Point(15, 204);
            this.lstTransactions.Name = "lstTransactions";
            this.lstTransactions.Size = new System.Drawing.Size(416, 160);
            this.lstTransactions.TabIndex = 9;
            this.lstTransactions.SelectedIndexChanged += new System.EventHandler(this.lstTransactions_SelectedIndexChanged);
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(494, 29);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(75, 23);
            this.btnAdd.TabIndex = 10;
            this.btnAdd.Text = "Add";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // btnRemove
            // 
            this.btnRemove.Location = new System.Drawing.Point(494, 74);
            this.btnRemove.Name = "btnRemove";
            this.btnRemove.Size = new System.Drawing.Size(75, 23);
            this.btnRemove.TabIndex = 11;
            this.btnRemove.Text = "Remove";
            this.btnRemove.UseVisualStyleBackColor = true;
            this.btnRemove.Click += new System.EventHandler(this.btnRemove_Click);
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(494, 121);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(75, 23);
            this.btnClear.TabIndex = 12;
            this.btnClear.Text = "Clear";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(494, 166);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 23);
            this.btnExit.TabIndex = 13;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // frmCheckingAccountFiles
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(587, 383);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnRemove);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.lstTransactions);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.lblBalance);
            this.Controls.Add(this.txtCheckNumber);
            this.Controls.Add(this.txtPayee);
            this.Controls.Add(this.txtTransactionDate);
            this.Controls.Add(this.txtTransactionAmount);
            this.Controls.Add(this.grpTType);
            this.Controls.Add(this.lblChkNum);
            this.Controls.Add(this.lblPayee);
            this.Controls.Add(this.lblTransactionDate);
            this.Controls.Add(this.lblTransactionAmount);
            this.Name = "frmCheckingAccountFiles";
            this.Text = "CheckingAccountFiles";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.frmCheckingAccountFiles_FormClosed);
            this.Load += new System.EventHandler(this.frmCheckingAccountFiles_Load);
            this.grpTType.ResumeLayout(false);
            this.grpTType.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblTransactionAmount;
        private System.Windows.Forms.Label lblTransactionDate;
        private System.Windows.Forms.Label lblPayee;
        private System.Windows.Forms.Label lblChkNum;
        private System.Windows.Forms.GroupBox grpTType;
        private System.Windows.Forms.RadioButton rbServiceFee;
        private System.Windows.Forms.RadioButton rbDeposit;
        private System.Windows.Forms.RadioButton rbWithdrawal;
        private System.Windows.Forms.TextBox txtTransactionAmount;
        private System.Windows.Forms.TextBox txtTransactionDate;
        private System.Windows.Forms.TextBox txtPayee;
        private System.Windows.Forms.TextBox txtCheckNumber;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label lblBalance;
        private System.Windows.Forms.ListBox lstTransactions;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button btnRemove;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnExit;
    }
}

