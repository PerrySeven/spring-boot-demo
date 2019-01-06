package demoapp.service.IService;

public class DefaultService implements IDefaultService {



    @Override
    public String getData(int a)
    {
        MoreData moreData = new MoreData();
        return moreData.getData();
    }

    public class MoreData
    {
        public String getData()
        {
            return "2";
        }
    }
}
