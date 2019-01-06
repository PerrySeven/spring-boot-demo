package demoapp.service.IService;

public interface IDefaultService {
    public default void defaultFunc()
    {}

    public static void getData()
    {}

    public String getData(int a);

}
