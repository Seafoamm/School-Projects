using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ScoreCalculator
{
    public partial class frmScoreCalculator : Form
    {
        public frmScoreCalculator()
        {
            InitializeComponent();
        }

        //declaring variables and setting to 0
        int scoreTotal = 0;
        int scoreCount = 0;
        

        private void btnAdd_Click(object sender, EventArgs e)
        {
            //try-catch statement for score validation
            try
            {
                //declare and set score to user input
                int score = int.Parse(txtScore.Text);

                //perform action if score is between 0 and 100
                if (score <= 100 && score >= 0)
                {
                    //add/manipulate values
                    scoreTotal += score;
                    scoreCount++;
                    //declare and set average value
                    decimal average = scoreTotal / scoreCount;

                    //display new values onto form
                    txtScoreTotal.Text = scoreTotal.ToString();
                    txtScoreCount.Text = scoreCount.ToString();
                    txtAverage.Text = average.ToString();

                    //set focus back on score text box
                    txtScore.Focus();

                }

                //if it's an integer that's not between 0 and 100
                else
                {
                    MessageBox.Show("Please put a number between 0 and 100", "Error");
                }
            }

            //try-catch statement for score validation - if it's not an integer
            catch (FormatException)
            {
                MessageBox.Show("Please put in an integer between 0 and 100 into the score text box", "Error");
            }
        }

        //clear scores button
        private void btnClear_Click(object sender, EventArgs e)
        {
            //reset variable values
            scoreTotal = 0;
            scoreCount = 0;

            //clear text boxes
            txtScore.Text = "";
            txtScoreTotal.Text = "";
            txtScoreCount.Text = "";
            txtAverage.Text = "";

            //set focus back on score text box
            txtScore.Focus();
        }

        //exit button
        private void btnExit_Click(object sender, EventArgs e)
        {
            //close the form
            this.Close();
        }

       
    }
}
