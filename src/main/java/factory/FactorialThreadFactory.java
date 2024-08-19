package factory;

import java.util.HashMap;
import java.util.Map;

import static constants.Constants.PLATFORM;
import static constants.Constants.VIRTUAL;

public class FactorialThreadFactory
{

    private static FactorialThreadFactory factorialThreadFactory=null;
    private Map<String,FactorialThread> factorialThreadFactoryOutlet;

    private FactorialThreadFactory() {
        factorialThreadFactoryOutlet = new HashMap<String,FactorialThread>();
        factorialThreadFactoryOutlet.put(PLATFORM,new PlatformFactorial());
        factorialThreadFactoryOutlet.put(VIRTUAL,new VirtualFactorial());
    };


    public static synchronized FactorialThreadFactory getInstance()
    {
        if(factorialThreadFactory==null)
        {
            factorialThreadFactory= new FactorialThreadFactory();

        }
        return factorialThreadFactory;
    }

    public FactorialThread getThread(String threadtype)
    {
        if(factorialThreadFactoryOutlet.keySet().contains(threadtype))
        {
            return factorialThreadFactoryOutlet.get(threadtype);
        }
        else
        {
            System.out.println("You are asking a biscuit factory for nuts and bolts, probably you are crazy.");
            return null;
        }
    }

}
