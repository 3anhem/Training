package com.example.bai1tuan7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView datalist;
    EditText studentid;
    EditText studentname;
    Button btnLoad;
    Button btnAdd;
    Button btnFind;
    Button btnDelete;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datalist = (TextView) findViewById(R.id.tvData);
        studentid = (EditText) findViewById(R.id.txtId);
        studentname = (EditText) findViewById(R.id.txtName);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnFind = (Button) findViewById(R.id.btnFind);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        btnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent(v);
            }
        });

        btnUpdate.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStudent(v);
            }
        });

        btnLoad.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadStudents(v);
            }
        });

        btnFind.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                findAllStudent(v);
            }
        });

        btnDelete.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteStudent(v);
            }
        });
    }

    public void addStudent(View view) {

        DataHandler dbHandler = new DataHandler(this, null, null, 1);
        int id = Integer.parseInt(studentid.getText().toString());
        String name = studentname.getText().toString();
        Student student = new Student(id, name);
        dbHandler.addDataHandler(student);
        studentid.setText("");
        studentname.setText("");
    }

    public void loadStudents(View view) {
        DataHandler dbHandler = new DataHandler(this, null, null, 1);
        datalist.setText(dbHandler.loadDataHandler());
        studentid.setText("");
        studentname.setText("");
    }

    public void findFirstStudent(View view) {
        DataHandler dbHandler = new DataHandler(this, null, null, 1);
        Student student =
                dbHandler.findFisrtDataHandler(studentname.getText().toString());
        if (student != null) {
            datalist.setText(String.valueOf(student.getStudentID()) + " " + student.getStudentName()
                    + System.getProperty("line.separator"));
            studentid.setText("");
            studentname.setText("");
        } else {
            datalist.setText("No Match Found");
            studentid.setText("");
            studentname.setText("");
        }
    }

    public void findAllStudent(View view) {
        DataHandler dbHandler = new DataHandler(this, null, null, 1);
        List<Student> lst =
                dbHandler.findAllDataHandler(studentname.getText().toString());
        String studentsList = "";
        if (!lst.isEmpty()) {
            for (Student st : lst) {
                studentsList += String.valueOf(st.getStudentID()) + " " + st.getStudentName()
                        + System.getProperty("line.separator");
                studentid.setText("");
                studentname.setText("");
            }
            datalist.setText(studentsList);
        } else {
            datalist.setText("No Match Found");
            studentid.setText("");
            studentname.setText("");
        }
    }

    public void deleteStudent(View view) {
        DataHandler dbHandler = new DataHandler(this, null,
                null, 1);
        boolean result = dbHandler.deleteDataHandler(Integer.parseInt(
                studentid.getText().toString()));
        if (result) {
            studentid.setText("");
            studentname.setText("");
            datalist.setText("Student Deleted");
        } else
            studentid.setText("No Match Found");
    }

    public void updateStudent(View view) {
        DataHandler dbHandler = new DataHandler(this, null,
                null, 1);
        boolean result = dbHandler.updateDataHandler(Integer.parseInt(
                studentid.getText().toString()), studentname.getText().toString());
        if (result) {
            studentid.setText("");
            studentname.setText("");
            datalist.setText("Student Updated");
        } else
            studentid.setText("No Match Found");
    }

}
