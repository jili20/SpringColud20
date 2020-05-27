import java.time.ZonedDateTime;

/**
 * @author bing  @create 2020/5/27 4:15 下午
 */
public class T2
{
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);

        //2020-05-27T16:16:11.404+08:00[Asia/Shanghai]
    }
}
