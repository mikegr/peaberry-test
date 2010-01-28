package at.tuwien.ifs.hoppla;

import org.ops4j.peaberry.ServiceRegistry;
import org.ops4j.peaberry.Peaberry;
import com.google.inject.Injector;
import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import at.tuwien.ifs.hoppla.acquisition.*;
import static org.ops4j.peaberry.Peaberry.*;
import static org.ops4j.peaberry.util.TypeLiterals.*;
import org.ops4j.peaberry.util.TypeLiterals;
import org.apache.log4j.BasicConfigurator;

import javax.inject.Singleton;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        BasicConfigurator.configure();
        Injector inj = Guice.createInjector(new Config());
        Workflow wf =  inj.getInstance(Workflow.class);
        wf.showPlugins();        

    }
    public static class Config extends AbstractModule {
        
        @Override
        protected void configure() {

            HopplaServiceRegistry reg = new HopplaServiceRegistry();

            bind(Core.class).to(DefaultCore.class);



            bind(export(Acquisition.class)).toProvider(service(new SSHAcquisition()).in(reg).export().direct());
            

            //bind(export(Acquisition.class)).toProvider(service(new EmailAcquisition()).export());
            //bind(export(Acquisition.class)).toProvider(service(new HDAcquisition()).export());
            
            bind(iterable(Acquisition.class)).toProvider(service(Acquisition.class).in(reg).multiple());
            
        }
    }
}
