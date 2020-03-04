using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

//Brandon Lu Exercise 7 2/21/2019

namespace StudentForm
{
    public partial class StudentForm : Form
    {
        public StudentForm()
        {
            InitializeComponent();
        }

        //list to hold students to add to listbox
        List<Student> studentList = new List<Student>();

        //when listbox selected index is changed
        private void lstStudents_SelectedIndexChanged(object sender, EventArgs e)
        {
            int index = lstStudents.SelectedIndex;

            //if something is selected, display appropriate data to textboxes based on selected listbox item
            if (index != -1)
            {
                SetValues(
                    studentList[index].FirstName,
                    studentList[index].LastName,
                    studentList[index].StudentID,
                    studentList[index].ApplicationDate,
                    studentList[index].AcceptanceDate,
                    studentList[index].CreditsCompleted,
                    studentList[index].GradePointAverage
                    );
            }
        }

        //when process button is clicked
        private void btnProcess_Click(object sender, EventArgs e)
        {
            //make new student to populate with data
            Student newStudent;

            //if data is valid, put textbox info into the new student, otherwise display error message and following actions are not taken
            if (
                   Validator.IsPresent(txtFirstName)
                && Validator.IsPresent(txtLastName)
                && Validator.IsPresent(txtSID)
                && Validator.IsPresent(txtAppDate)
                && Validator.IsPresent(txtCredits)
                && Validator.IsPresent(txtGPA)

                && Validator.IsInteger(txtCredits)
                && Validator.IsDecimal(txtGPA)
                && Validator.IsZeroOrGreater(txtCredits)
                && Validator.IsZeroOrGreater(txtGPA)

                && Validator.IsValidDate(txtAppDate)
                && Validator.IsValidDate(txtAcceptDate)
                && Validator.IsTodayOrBefore(txtAppDate)
                )
            {
                //fill new student with textbox data
                newStudent = new Student
                    (
                    txtFirstName.Text,
                    txtLastName.Text,
                    txtSID.Text,
                    txtAppDate.Text,
                    txtAcceptDate.Text,
                    txtCredits.Text,
                    txtGPA.Text
                    );

                //add the student to the list
                studentList.Add(newStudent);

                //add the students to the listbox
                RefreshListBox();
            }
        }

        //when edit button is clicked
        private void btnEdit_Click(object sender, EventArgs e)
        {
            //make a new student to replace old student
            Student editedStudent;

            int index = lstStudents.SelectedIndex;

            //if everything is valid do code, otherwise display error message and do nothing
            if (
                   Validator.IsPresent(txtFirstName)
                && Validator.IsPresent(txtLastName)
                && Validator.IsPresent(txtSID)
                && Validator.IsPresent(txtAppDate)
                && Validator.IsPresent(txtCredits)
                && Validator.IsPresent(txtGPA)

                && Validator.IsInteger(txtCredits)
                && Validator.IsDecimal(txtGPA)
                && Validator.IsZeroOrGreater(txtCredits)
                && Validator.IsZeroOrGreater(txtGPA)

                && Validator.IsValidDate(txtAppDate)
                && Validator.IsValidDate(txtAcceptDate)
                && Validator.IsTodayOrBefore(txtAppDate)

                && index != -1
                )
            {
                //fill new student with data
                editedStudent = new Student
                    (
                    txtFirstName.Text,
                    txtLastName.Text,
                    txtSID.Text,
                    txtAppDate.Text,
                    txtAcceptDate.Text,
                    txtCredits.Text,
                    txtGPA.Text
                    );

                //remove the old student and insert the new student in its place in the list
                studentList.Remove(studentList[index]);
                studentList.Insert(index, editedStudent);

                //refill the list box with new student list
                RefreshListBox();
            }
        }

        //when clear button is clicked
        private void btnClear_Click(object sender, EventArgs e)
        {
            //set all textboxes to empty
            SetValues("", "", "", "", "", "", "");
        }

        //when exit button is clicked
        private void btnExit_Click(object sender, EventArgs e)
        {
            //close application
            this.Close();
        }

        //set the text values of textboxes
        private void SetValues(string firstname, string lastname, string sid, string appdate, string acceptdate, string credits, string gpa)
        {
            txtFirstName.Text = firstname;
            txtLastName.Text = lastname;
            txtSID.Text = sid;
            txtAppDate.Text = appdate;
            txtAcceptDate.Text = acceptdate;
            txtCredits.Text = credits;
            txtGPA.Text = gpa;
        }

        //clear all items in the listbox and add all items from student list
        private void RefreshListBox()
        {
            lstStudents.Items.Clear();
            foreach (Student student in studentList)
            {
                lstStudents.Items.Add(student);
            }
        }
    }
}
