namespace StudentForm
{
    partial class StudentForm
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
            this.lblFirstName = new System.Windows.Forms.Label();
            this.txtFirstName = new System.Windows.Forms.TextBox();
            this.lblLastName = new System.Windows.Forms.Label();
            this.lblSID = new System.Windows.Forms.Label();
            this.lblAppDate = new System.Windows.Forms.Label();
            this.lblAcceptDate = new System.Windows.Forms.Label();
            this.lblCredits = new System.Windows.Forms.Label();
            this.lblGPA = new System.Windows.Forms.Label();
            this.txtLastName = new System.Windows.Forms.TextBox();
            this.txtSID = new System.Windows.Forms.TextBox();
            this.txtCredits = new System.Windows.Forms.TextBox();
            this.txtGPA = new System.Windows.Forms.TextBox();
            this.lstStudents = new System.Windows.Forms.ListBox();
            this.btnProcess = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnEdit = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.txtAppDate = new System.Windows.Forms.TextBox();
            this.txtAcceptDate = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // lblFirstName
            // 
            this.lblFirstName.AutoSize = true;
            this.lblFirstName.Location = new System.Drawing.Point(409, 15);
            this.lblFirstName.Name = "lblFirstName";
            this.lblFirstName.Size = new System.Drawing.Size(60, 13);
            this.lblFirstName.TabIndex = 0;
            this.lblFirstName.Text = "First Name:";
            // 
            // txtFirstName
            // 
            this.txtFirstName.Location = new System.Drawing.Point(503, 12);
            this.txtFirstName.Name = "txtFirstName";
            this.txtFirstName.Size = new System.Drawing.Size(100, 20);
            this.txtFirstName.TabIndex = 1;
            this.txtFirstName.Tag = "First Name";
            // 
            // lblLastName
            // 
            this.lblLastName.AutoSize = true;
            this.lblLastName.Location = new System.Drawing.Point(409, 41);
            this.lblLastName.Name = "lblLastName";
            this.lblLastName.Size = new System.Drawing.Size(61, 13);
            this.lblLastName.TabIndex = 2;
            this.lblLastName.Text = "Last Name:";
            // 
            // lblSID
            // 
            this.lblSID.AutoSize = true;
            this.lblSID.Location = new System.Drawing.Point(409, 67);
            this.lblSID.Name = "lblSID";
            this.lblSID.Size = new System.Drawing.Size(61, 13);
            this.lblSID.TabIndex = 4;
            this.lblSID.Text = "Student ID:";
            // 
            // lblAppDate
            // 
            this.lblAppDate.AutoSize = true;
            this.lblAppDate.Location = new System.Drawing.Point(409, 93);
            this.lblAppDate.Name = "lblAppDate";
            this.lblAppDate.Size = new System.Drawing.Size(88, 13);
            this.lblAppDate.TabIndex = 6;
            this.lblAppDate.Text = "Application Date:";
            // 
            // lblAcceptDate
            // 
            this.lblAcceptDate.AutoSize = true;
            this.lblAcceptDate.Location = new System.Drawing.Point(409, 120);
            this.lblAcceptDate.Name = "lblAcceptDate";
            this.lblAcceptDate.Size = new System.Drawing.Size(94, 13);
            this.lblAcceptDate.TabIndex = 8;
            this.lblAcceptDate.Text = "Acceptance Date:";
            // 
            // lblCredits
            // 
            this.lblCredits.AutoSize = true;
            this.lblCredits.Location = new System.Drawing.Point(409, 147);
            this.lblCredits.Name = "lblCredits";
            this.lblCredits.Size = new System.Drawing.Size(95, 13);
            this.lblCredits.TabIndex = 10;
            this.lblCredits.Text = "Credits Completed:";
            // 
            // lblGPA
            // 
            this.lblGPA.AutoSize = true;
            this.lblGPA.Location = new System.Drawing.Point(409, 173);
            this.lblGPA.Name = "lblGPA";
            this.lblGPA.Size = new System.Drawing.Size(32, 13);
            this.lblGPA.TabIndex = 12;
            this.lblGPA.Text = "GPA:";
            // 
            // txtLastName
            // 
            this.txtLastName.Location = new System.Drawing.Point(503, 38);
            this.txtLastName.Name = "txtLastName";
            this.txtLastName.Size = new System.Drawing.Size(100, 20);
            this.txtLastName.TabIndex = 3;
            this.txtLastName.Tag = "Last Name";
            // 
            // txtSID
            // 
            this.txtSID.Location = new System.Drawing.Point(503, 64);
            this.txtSID.Name = "txtSID";
            this.txtSID.Size = new System.Drawing.Size(100, 20);
            this.txtSID.TabIndex = 5;
            this.txtSID.Tag = "Student ID";
            // 
            // txtCredits
            // 
            this.txtCredits.Location = new System.Drawing.Point(503, 144);
            this.txtCredits.Name = "txtCredits";
            this.txtCredits.Size = new System.Drawing.Size(100, 20);
            this.txtCredits.TabIndex = 11;
            this.txtCredits.Tag = "Credits Completed";
            // 
            // txtGPA
            // 
            this.txtGPA.Location = new System.Drawing.Point(503, 170);
            this.txtGPA.Name = "txtGPA";
            this.txtGPA.Size = new System.Drawing.Size(100, 20);
            this.txtGPA.TabIndex = 13;
            this.txtGPA.Tag = "GPA";
            // 
            // lstStudents
            // 
            this.lstStudents.FormattingEnabled = true;
            this.lstStudents.Location = new System.Drawing.Point(12, 12);
            this.lstStudents.Name = "lstStudents";
            this.lstStudents.Size = new System.Drawing.Size(354, 173);
            this.lstStudents.TabIndex = 18;
            this.lstStudents.SelectedIndexChanged += new System.EventHandler(this.lstStudents_SelectedIndexChanged);
            // 
            // btnProcess
            // 
            this.btnProcess.Location = new System.Drawing.Point(412, 203);
            this.btnProcess.Name = "btnProcess";
            this.btnProcess.Size = new System.Drawing.Size(75, 23);
            this.btnProcess.TabIndex = 14;
            this.btnProcess.Text = "&Process";
            this.btnProcess.UseVisualStyleBackColor = true;
            this.btnProcess.Click += new System.EventHandler(this.btnProcess_Click);
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(522, 203);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(75, 23);
            this.btnClear.TabIndex = 15;
            this.btnClear.Text = "&Clear";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // btnEdit
            // 
            this.btnEdit.Location = new System.Drawing.Point(12, 203);
            this.btnEdit.Name = "btnEdit";
            this.btnEdit.Size = new System.Drawing.Size(75, 23);
            this.btnEdit.TabIndex = 17;
            this.btnEdit.Text = "E&dit";
            this.btnEdit.UseVisualStyleBackColor = true;
            this.btnEdit.Click += new System.EventHandler(this.btnEdit_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(628, 203);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 23);
            this.btnExit.TabIndex = 16;
            this.btnExit.Text = "E&xit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // txtAppDate
            // 
            this.txtAppDate.Location = new System.Drawing.Point(503, 90);
            this.txtAppDate.Name = "txtAppDate";
            this.txtAppDate.Size = new System.Drawing.Size(100, 20);
            this.txtAppDate.TabIndex = 7;
            this.txtAppDate.Tag = "Application Date";
            // 
            // txtAcceptDate
            // 
            this.txtAcceptDate.Location = new System.Drawing.Point(503, 117);
            this.txtAcceptDate.Name = "txtAcceptDate";
            this.txtAcceptDate.Size = new System.Drawing.Size(100, 20);
            this.txtAcceptDate.TabIndex = 9;
            this.txtAcceptDate.Tag = "Acceptance Date";
            // 
            // StudentForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(722, 248);
            this.Controls.Add(this.txtAcceptDate);
            this.Controls.Add(this.txtAppDate);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnEdit);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnProcess);
            this.Controls.Add(this.lstStudents);
            this.Controls.Add(this.txtGPA);
            this.Controls.Add(this.txtCredits);
            this.Controls.Add(this.txtSID);
            this.Controls.Add(this.txtLastName);
            this.Controls.Add(this.lblGPA);
            this.Controls.Add(this.lblCredits);
            this.Controls.Add(this.lblAcceptDate);
            this.Controls.Add(this.lblAppDate);
            this.Controls.Add(this.lblSID);
            this.Controls.Add(this.lblLastName);
            this.Controls.Add(this.txtFirstName);
            this.Controls.Add(this.lblFirstName);
            this.Name = "StudentForm";
            this.Text = "StudentForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblFirstName;
        private System.Windows.Forms.TextBox txtFirstName;
        private System.Windows.Forms.Label lblLastName;
        private System.Windows.Forms.Label lblSID;
        private System.Windows.Forms.Label lblAppDate;
        private System.Windows.Forms.Label lblAcceptDate;
        private System.Windows.Forms.Label lblCredits;
        private System.Windows.Forms.Label lblGPA;
        private System.Windows.Forms.TextBox txtLastName;
        private System.Windows.Forms.TextBox txtSID;
        private System.Windows.Forms.TextBox txtCredits;
        private System.Windows.Forms.TextBox txtGPA;
        private System.Windows.Forms.ListBox lstStudents;
        private System.Windows.Forms.Button btnProcess;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnEdit;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.TextBox txtAppDate;
        private System.Windows.Forms.TextBox txtAcceptDate;
    }
}

