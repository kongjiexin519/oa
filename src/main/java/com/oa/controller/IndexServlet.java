package com.oa.controller;

import com.oa.entity.Department;
import com.oa.entity.Employee;
import com.oa.entity.Node;
import com.oa.entity.User;
import com.oa.service.DepartmentService;
import com.oa.service.EmployeeService;
import com.oa.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private UserService userService = new UserService();
    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("login_user");
        Employee employee = employeeService.selectById(user.getEmployeeId());
        List<Node> nodeList = userService.selectNodeByUserId(user.getUserId());
        Department department = departmentService.selectById(employee.getDepartmentId());
        request.setAttribute("node_list", nodeList);
        session.setAttribute("current_employee", employee);
        session.setAttribute("current_department", department);
        request.getRequestDispatcher("/index.ftl").forward(request, response);
    }
}
