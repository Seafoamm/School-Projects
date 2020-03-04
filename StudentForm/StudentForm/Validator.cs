using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

//Brandon Lu Exercise 7 2/21/2019

namespace StudentForm
{
    public static class Validator
    {
        //if the textbox's text has something, return true, else return false and display error message
        public static bool IsPresent(TextBox txt)
        {
            if (txt.Text == "")
            {
                ShowErrorMessage(txt, "is a required field.");
                return false;
            }
            return true;
        }

        //if the textbox's text is a number that is 0 or greater, return true, else return false and display error message
        public static bool IsZeroOrGreater(TextBox txt)
        {
            decimal number = decimal.Parse(txt.Text);
            if (number <= 0)
            {
                ShowErrorMessage(txt, "must be zero or greater amount.");
                return false;
            }
            return true;
        }

        //if the textbox's text is an integer, return true, otherwise return false and display error message
        public static bool IsInteger(TextBox txt)
        {
            if (int.TryParse(txt.Text, out int number) == false)
            {
                ShowErrorMessage(txt, "must be an integer.");
                return false;
            }
            return true;
        }

        //if the textbox's text is an decimal, return true, otherwise return false and display error message
        public static bool IsDecimal(TextBox txt)
        {
            if (decimal.TryParse(txt.Text, out decimal number) == false)
            {
                ShowErrorMessage(txt, "must be a decimal.");
                return false;
            }
            return true;
        }

        //if the textbox's text is a date that is today or before, return true, otherwise return false and display error message
        public static bool IsTodayOrBefore(TextBox txt)
        {
            if (DateTime.Parse(txt.Text) > DateTime.Today)
            {
                ShowErrorMessage(txt, "must be on or before today.");
                return false;
            }
            return true;
        }

        //if the textbox's text is a valid DateTime value, return true, otherwise return false and display error message
        //exception: if the textbox is acceptance date, allow an empty textbox to be valid
        public static bool IsValidDate(TextBox txt)
        {
            if (txt.Tag == "Acceptance Date" && txt.Text == "")
            {
                return true;
            }
            if (DateTime.TryParse(txt.Text, out DateTime date) == false)
            {
                ShowErrorMessage(txt, "must be a valid date.");
                return false;
            }
            return true;
        }

        //show a messagebox with a message that includes the tag of the textbox along with a custom message
        private static void ShowErrorMessage(TextBox txt, string message)
        {
            MessageBox.Show(txt.Tag + " " + message, "Data Error");
            txt.Focus();
        }

    }
}
