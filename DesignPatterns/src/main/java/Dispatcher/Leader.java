package Dispatcher;


import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    Map<String, IEmployee> employees = new HashMap<String, IEmployee>();

    public Leader() {
        employees.put("加密", new Employee("加密"));
        employees.put("登录", new Employee("登录"));
    }
    @Override
    public void work(String command) {
        employees.get(command).work(command);
    }

}
