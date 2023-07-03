package etu1922.framework.servlet;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

import etu1922.framework.Annotation;
import etu1922.framework.Mapping;
import etu1922.framework.Outil;
import etu1922.framework.ModelView;


public class FrontServlet extends HttpServlet {
    HashMap<String,Mapping> mappingUrls = new HashMap<String,Mapping>();

    public void init() {
        String packageName = "test_framework.Test";
        try {
            List<Class> allClass = Outil.getClass(packageName);
            for (int i = 0; i < allClass.size(); i++) {
                Class temp = allClass.get(i);
                Method[] methods = temp.getDeclaredMethods();
                for (int j = 0; j < methods.length; j++) {
                    if (methods[j].isAnnotationPresent(Annotation.class)) {
                        Mapping mapping = new Mapping(temp.getName(),methods[j].getName());
                        this.mappingUrls.put(methods[j].getAnnotation(Annotation.class).url(), mapping);
                    }
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
        public void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                PrintWriter out = response.getWriter();
                try {
                String url = request.getRequestURI().substring(request.getContextPath().length()+1);
                out.println(this.mappingUrls);
                if (this.mappingUrls.containsKey(url))
                {
                    Mapping mapping = this.mappingUrls.get(url);
                    Class clazz = Class.forName(mapping.getClassName());
                    Object object = clazz.getConstructor().newInstance();
                    Method[] methods = object.getClass().getDeclaredMethods();
                    Method equalMethod = null;
                    for (int i = 0; i < methods.length; i++) {
                        if (methods[i].getName().trim().compareTo(mapping.getMethod())==0) {
                            equalMethod = methods[i];
                            break;
                        }
                    }
                    Object[] objects = new Object[1];
                    Object returnObject = equalMethod.invoke(object);
                    if (returnObject instanceof ModelView) {
                        ModelView modelview = (ModelView) returnObject;
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher(modelview.getView());
                        requestDispatcher.forward(request, response);
                    }
            }
        }catch (Exception e) {e.printStackTrace(out);}
        }

        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            processRequest(request, response);
        }

        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            processRequest(request, response);
        }
}