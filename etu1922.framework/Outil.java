package etu1922.framework;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Outil {
    public static List<Class> getClass(String packages){
        List<Class> listClass = new ArrayList<>();
        String path = packages.replaceAll("[.]", "\\\\");
        URL packageUrl = Thread.currentThread().getContextClassLoader().getResource(path);
        File packDir =new File(packageUrl.toURI());
        File[] inside = packDir.listFiles(file->file.getName().endsWith(".class"));
        List<Class> lists = new ArrayList<>();
        for(File f : inside){
            String c = packages+"."+f.getName().substring(0,f.getName().lastIndexOf("."));
            lists.add(Class.forName(c));
        }
        return listClass;
    }
}
