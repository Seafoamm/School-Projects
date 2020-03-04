using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

//Brandon Lu Exercise 7 2/21/2019

namespace StudentForm
{
    public class Student
    {
        //private fields
        string firstName;
        string lastName;
        string SID;
        string appDate;
        string acceptDate;
        string credits;
        string GPA;

        //constructor that accepts strings to assign to properties
        public Student(string _firstName, string _lastName, string _SID, string _appDate, string _acceptDate, string _credits, string _GPA)
        {
            FirstName = _firstName;
            LastName = _lastName;
            StudentID = _SID;
            ApplicationDate = _appDate;
            AcceptanceDate = _acceptDate;
            CreditsCompleted = _credits;
            GradePointAverage = _GPA;
        }

        //properties to work with private fields
        public string FirstName
        {
            get
            {
                return firstName;
            }

            set
            {
                firstName = value;
            }
        }

        public string LastName
        {
            get
            {
                return lastName;
            }

            set
            {
                lastName = value;
            }
        }

        public string StudentID
        {
            get
            {
                return SID;
            }

            set
            {
                SID = value;
            }
        }

        public string ApplicationDate
        {
            get
            {
                return appDate;
            }

            set
            {
                appDate = value;
            }
        }

        public string AcceptanceDate
        {
            get
            {
                return acceptDate;
            }

            set
            {
                acceptDate = value;
            }
        }

        public string CreditsCompleted
        {
            get
            {
                return credits;
            }

            set
            {
                credits = value;
            }
        }

        public string GradePointAverage
        {
            get
            {
                return GPA;
            }

            set
            {
                GPA = value;
            }
        }

        //return the first name, last name, and student id concatenated if tostring() is called
        public override string ToString()
        {
            return firstName + " " + lastName + " " + SID;
        }

    }
}
