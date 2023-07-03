package test_framework.Test;
import etu1922.framework.Annotation;
import etu1922.framework.ModelView;

public class Emp {
    @Annotation(url="findAll")
    public void findAll(){
        System.out.println("findAll");
    }

    @Annotation(url="getUrl")
    public ModelView getModel(){
        ModelView temp = new ModelView();
        temp.setView("Teste.jsp");

        return temp;
    }
}
