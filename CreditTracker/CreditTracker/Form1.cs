using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CreditTracker
{
    public partial class frmCreditTracker : Form
    {
        public frmCreditTracker()
        {
            InitializeComponent();
        }

        int creditCount = 0;
        int creditTotal = 0;
        
        private void btnProcess_Click(object sender, EventArgs e)
        {

            try
            {
                int creditCompleted = int.Parse(txtCredits.Text);
                decimal GPA = Decimal.Parse(txtGPA.Text);
                if (GPA > 4 | GPA < 0)
                {
                    MessageBox.Show("GPA must be a decimal between 0 and 4");
                }
                else if (creditCompleted < 0)
                {
                    MessageBox.Show("Credits must be greater than zero");
                }
                else if (txtFirstName.Text != "" && txtLastName.Text != "" && txtCredits.Text != "" && txtGPA.Text != "" && txtStudentID.Text != "")
                {
                    creditTotal += creditCompleted;
                    creditCount++;
                    int creditAverage = creditTotal / creditCount;
                    if (creditCompleted < creditAverage)
                    {
                        MessageBox.Show(txtFirstName.Text + " " + txtLastName.Text + "\n" + txtStudentID.Text + "\n" + txtFirstName.Text + "\'s credits are lower than the average credits completed.");
                    }
                    else if (creditCompleted == creditAverage)
                    {
                        MessageBox.Show(txtFirstName.Text + " " + txtLastName.Text + "\n" + txtStudentID.Text + "\n" + txtFirstName.Text + "\'s credits are the same as the average credits completed.");
                    }
                    else if (creditCompleted > creditAverage)
                    {
                        MessageBox.Show(txtFirstName.Text + " " + txtLastName.Text + "\n" + txtStudentID.Text + "\n" + txtFirstName.Text + "\'s credits are higher than the average credits completed.");
                    }
                }
                else if (txtFirstName.Text == "" | txtLastName.Text == "" | txtCredits.Text == "" | txtGPA.Text == "" | txtStudentID.Text == "")
                {
                    MessageBox.Show("Please fill in all the text boxes");
                }
            }
            catch (FormatException)
            {
                MessageBox.Show("Please put in an integer for credits");
            }
          
            
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            creditCount = 0;
            creditTotal = 0;

            txtFirstName.Text = "";
            txtLastName.Text = "";
            txtGPA.Text = "";
            txtCredits.Text = "";
            txtStudentID.Text = "";

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
