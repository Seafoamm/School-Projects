namespace CheckingAccountClasses
{
    partial class frmCheckingAccountClasses
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
            this.lblCheckNumber = new System.Windows.Forms.Label();
            this.txtTransactionAmount = new System.Windows.Forms.TextBox();
            this.txtPayee = new System.Windows.Forms.TextBox();
            this.txtCheckNumber = new System.Windows.Forms.TextBox();
            this.lstTransactions = new System.Windows.Forms.ListBox();
            this.grpTransactionType = new System.Windows.Forms.GroupBox();
            this.rbServiceFee = new System.Windows.Forms.RadioButton();
            this.rbWithdrawal = new System.Windows.Forms.RadioButton();
            this.rbDeposit = new System.Windows.Forms.RadioButton();
            this.label6 = new System.Windows.Forms.Label();
            this.lblBalance = new System.Windows.Forms.Label();
            this.btnProcess = new System.Windows.Forms.Button();
            this.btnRemove = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.dtpTransactionDate = new System.Windows.Forms.DateTimePicker();
            this.grpTransactionType.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblTransactionAmount
            // 
            this.lblTransactionAmount.AutoSize = true;
            this.lblTransactionAmount.Location = new System.Drawing.Point(24, 9);
            this.lblTransactionAmount.Name = "lblTransactionAmount";
            this.lblTransactionAmount.Size = new System.Drawing.Size(105, 13);
            this.lblTransactionAmount.TabIndex = 0;
            this.lblTransactionAmount.Text = "Transaction Amount:";
            // 
            // lblTransactionDate
            // 
            this.lblTransactionDate.AutoSize = true;
            this.lblTransactionDate.Location = new System.Drawing.Point(24, 45);
            this.lblTransactionDate.Name = "lblTransactionDate";
            this.lblTransactionDate.Size = new System.Drawing.Size(92, 13);
            this.lblTransactionDate.TabIndex = 2;
            this.lblTransactionDate.Text = "Transaction Date:";
            // 
            // lblPayee
            // 
            this.lblPayee.AutoSize = true;
            this.lblPayee.Location = new System.Drawing.Point(24, 79);
            this.lblPayee.Name = "lblPayee";
            this.lblPayee.Size = new System.Drawing.Size(40, 13);
            this.lblPayee.TabIndex = 3;
            this.lblPayee.Text = "Payee:";
            // 
            // lblCheckNumber
            // 
            this.lblCheckNumber.AutoSize = true;
            this.lblCheckNumber.Location = new System.Drawing.Point(24, 113);
            this.lblCheckNumber.Name = "lblCheckNumber";
            this.lblCheckNumber.Size = new System.Drawing.Size(81, 13);
            this.lblCheckNumber.TabIndex = 4;
            this.lblCheckNumber.Text = "Check Number:";
            // 
            // txtTransactionAmount
            // 
            this.txtTransactionAmount.Location = new System.Drawing.Point(157, 6);
            this.txtTransactionAmount.Name = "txtTransactionAmount";
            this.txtTransactionAmount.Size = new System.Drawing.Size(100, 20);
            this.txtTransactionAmount.TabIndex = 5;
            this.txtTransactionAmount.Tag = "Transaction Amount";
            // 
            // txtPayee
            // 
            this.txtPayee.Location = new System.Drawing.Point(157, 76);
            this.txtPayee.Name = "txtPayee";
            this.txtPayee.Size = new System.Drawing.Size(100, 20);
            this.txtPayee.TabIndex = 8;
            this.txtPayee.Tag = "Payee";
            // 
            // txtCheckNumber
            // 
            this.txtCheckNumber.Location = new System.Drawing.Point(157, 110);
            this.txtCheckNumber.Name = "txtCheckNumber";
            this.txtCheckNumber.Size = new System.Drawing.Size(100, 20);
            this.txtCheckNumber.TabIndex = 9;
            this.txtCheckNumber.Tag = "Check Number";
            // 
            // lstTransactions
            // 
            this.lstTransactions.FormattingEnabled = true;
            this.lstTransactions.Location = new System.Drawing.Point(9, 144);
            this.lstTransactions.Name = "lstTransactions";
            this.lstTransactions.Size = new System.Drawing.Size(360, 199);
            this.lstTransactions.TabIndex = 10;
            this.lstTransactions.SelectedIndexChanged += new System.EventHandler(this.lstTransactions_SelectedIndexChanged);
            // 
            // grpTransactionType
            // 
            this.grpTransactionType.Controls.Add(this.rbServiceFee);
            this.grpTransactionType.Controls.Add(this.rbWithdrawal);
            this.grpTransactionType.Controls.Add(this.rbDeposit);
            this.grpTransactionType.Location = new System.Drawing.Point(378, 12);
            this.grpTransactionType.Name = "grpTransactionType";
            this.grpTransactionType.Size = new System.Drawing.Size(200, 100);
            this.grpTransactionType.TabIndex = 11;
            this.grpTransactionType.TabStop = false;
            this.grpTransactionType.Text = "Transaction Type";
            // 
            // rbServiceFee
            // 
            this.rbServiceFee.AutoSize = true;
            this.rbServiceFee.Location = new System.Drawing.Point(11, 66);
            this.rbServiceFee.Name = "rbServiceFee";
            this.rbServiceFee.Size = new System.Drawing.Size(82, 17);
            this.rbServiceFee.TabIndex = 2;
            this.rbServiceFee.TabStop = true;
            this.rbServiceFee.Tag = "Service Fee";
            this.rbServiceFee.Text = "Service Fee";
            this.rbServiceFee.UseVisualStyleBackColor = true;
            // 
            // rbWithdrawal
            // 
            this.rbWithdrawal.AutoSize = true;
            this.rbWithdrawal.Location = new System.Drawing.Point(11, 42);
            this.rbWithdrawal.Name = "rbWithdrawal";
            this.rbWithdrawal.Size = new System.Drawing.Size(78, 17);
            this.rbWithdrawal.TabIndex = 1;
            this.rbWithdrawal.TabStop = true;
            this.rbWithdrawal.Tag = "Withdrawal";
            this.rbWithdrawal.Text = "Withdrawal";
            this.rbWithdrawal.UseVisualStyleBackColor = true;
            // 
            // rbDeposit
            // 
            this.rbDeposit.AutoSize = true;
            this.rbDeposit.Location = new System.Drawing.Point(11, 15);
            this.rbDeposit.Name = "rbDeposit";
            this.rbDeposit.Size = new System.Drawing.Size(61, 17);
            this.rbDeposit.TabIndex = 0;
            this.rbDeposit.TabStop = true;
            this.rbDeposit.Tag = "Deposit";
            this.rbDeposit.Text = "Deposit";
            this.rbDeposit.UseVisualStyleBackColor = true;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(418, 144);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(49, 13);
            this.label6.TabIndex = 12;
            this.label6.Text = "Balance:";
            // 
            // lblBalance
            // 
            this.lblBalance.AutoSize = true;
            this.lblBalance.Location = new System.Drawing.Point(501, 144);
            this.lblBalance.Name = "lblBalance";
            this.lblBalance.Size = new System.Drawing.Size(45, 13);
            this.lblBalance.TabIndex = 13;
            this.lblBalance.Text = "balance";
            // 
            // btnProcess
            // 
            this.btnProcess.Location = new System.Drawing.Point(418, 181);
            this.btnProcess.Name = "btnProcess";
            this.btnProcess.Size = new System.Drawing.Size(75, 23);
            this.btnProcess.TabIndex = 14;
            this.btnProcess.Text = "Process";
            this.btnProcess.UseVisualStyleBackColor = true;
            this.btnProcess.Click += new System.EventHandler(this.btnProcess_Click);
            // 
            // btnRemove
            // 
            this.btnRemove.Location = new System.Drawing.Point(418, 226);
            this.btnRemove.Name = "btnRemove";
            this.btnRemove.Size = new System.Drawing.Size(75, 23);
            this.btnRemove.TabIndex = 15;
            this.btnRemove.Text = "Remove";
            this.btnRemove.UseVisualStyleBackColor = true;
            this.btnRemove.Click += new System.EventHandler(this.btnRemove_Click);
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(418, 271);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(75, 23);
            this.btnClear.TabIndex = 16;
            this.btnClear.Text = "Clear";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(418, 314);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 23);
            this.btnExit.TabIndex = 17;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // dtpTransactionDate
            // 
            this.dtpTransactionDate.Location = new System.Drawing.Point(157, 39);
            this.dtpTransactionDate.Name = "dtpTransactionDate";
            this.dtpTransactionDate.Size = new System.Drawing.Size(200, 20);
            this.dtpTransactionDate.TabIndex = 18;
            // 
            // frmCheckingAccountClasses
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(594, 378);
            this.Controls.Add(this.dtpTransactionDate);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnRemove);
            this.Controls.Add(this.btnProcess);
            this.Controls.Add(this.lblBalance);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.grpTransactionType);
            this.Controls.Add(this.lstTransactions);
            this.Controls.Add(this.txtCheckNumber);
            this.Controls.Add(this.txtPayee);
            this.Controls.Add(this.txtTransactionAmount);
            this.Controls.Add(this.lblCheckNumber);
            this.Controls.Add(this.lblPayee);
            this.Controls.Add(this.lblTransactionDate);
            this.Controls.Add(this.lblTransactionAmount);
            this.Name = "frmCheckingAccountClasses";
            this.Text = "Checking Account";
            this.Load += new System.EventHandler(this.frmCheckingAccountClasses_Load);
            this.grpTransactionType.ResumeLayout(false);
            this.grpTransactionType.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblTransactionAmount;
        private System.Windows.Forms.Label lblTransactionDate;
        private System.Windows.Forms.Label lblPayee;
        private System.Windows.Forms.Label lblCheckNumber;
        private System.Windows.Forms.TextBox txtTransactionAmount;
        private System.Windows.Forms.TextBox txtPayee;
        private System.Windows.Forms.TextBox txtCheckNumber;
        private System.Windows.Forms.ListBox lstTransactions;
        private System.Windows.Forms.GroupBox grpTransactionType;
        private System.Windows.Forms.RadioButton rbServiceFee;
        private System.Windows.Forms.RadioButton rbWithdrawal;
        private System.Windows.Forms.RadioButton rbDeposit;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label lblBalance;
        private System.Windows.Forms.Button btnProcess;
        private System.Windows.Forms.Button btnRemove;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.DateTimePicker dtpTransactionDate;
    }
}

