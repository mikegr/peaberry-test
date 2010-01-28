package at.tuwien.ifs.hoppla;

import org.ops4j.peaberry.*;
import org.ops4j.peaberry.util.SimpleExport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.util.HashMap;

/**
 * @author Michael Greifeneder - greifeneder@ifs.tuwien.ac.at
 */
@Named("hoppla")
public class HopplaServiceRegistry implements ServiceRegistry {
    
    private static Logger log = LoggerFactory.getLogger(HopplaServiceRegistry.class);

    HashMap<Class, Iterable> table = new HashMap<Class, Iterable>();

    public <T> Iterable<Import<T>> lookup(Class<T> tClass, AttributeFilter attributeFilter) {
        log.debug("lookup: " + tClass);
        return table.get(tClass);
    }

    public <T> void watch(Class<T> tClass, AttributeFilter attributeFilter, ServiceWatcher<? super T> serviceWatcher) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public <T> Export<T> add(Import<T> tImport) {
        log.debug("add: " + tImport);
        return new SimpleExport(tImport);
    }
}
