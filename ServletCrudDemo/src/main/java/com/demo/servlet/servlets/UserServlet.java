package com.demo.servlet.servlets;

import com.demo.servlet.model.User;
import com.demo.servlet.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {


    UserService userService = new UserService();
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if(id == null || name == null || email == null || mobile == null){
          response.setStatus(400);
          response.setContentType("application/json");
          response.getWriter().write("{\n" +
                  "    message : \"some fields are missing\"\n" +
                  "}");
        }

        User user = new User(id , name , email ,  mobile);

        User createdUser = userService.createUser(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write("{\n" +
                "    message : \"User Added SuccesdFully \"\n" +
                "}");

    }


    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
    String idParam = request.getParameter("id");

    if(idParam == null){
        List<User> allUser = userService.getAllUser();
        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson( allUser));
        return;
    }
    Integer id = Integer.parseInt(idParam);

    User userResp = userService.getUserById(id);

    if(userResp == null){
        response.setStatus(404);
        response.setContentType("application/json");
        response.getWriter().write("{\n" +
                "    message : \"User Not Found \"\n" +
                "}");
    }

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToSave(userResp));
    }


    @Override
    public void doPut(HttpServletRequest httpServletRequest,
                      HttpServletResponse httpServletResponse){

    }

    @Override
    public void doDelete(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse){

    }


    private String userToSave(User user){
        return "{\n" +
                "  \"id\": " + user.getId() + ",\n" +
                "  \"name\": \"" + user.getName() + "\",\n" +
                "  \"email\": \"" + user.getEmail() + "\",\n" +
                "  \"mobile\": \"" + user.getMobile() + "\"\n" +
                "}";
    }

    private String userToJson(List<User> users){
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for(int i = 0 ; i < users.size() ; i++){
            builder.append(userToJson((List<User>) users.get(i)));

            if(i < users.size() - 1){
                builder.append(",");
            }

            builder.append("]");

        }
        return  builder.toString();

    }

}
