package at.tuwien.ifs.hoppla.acquisition;

import com.google.inject.Inject;


/**
 * @author Michael Greifeneder - greifeneder@ifs.tuwien.ac.at
 */
public class Workflow {

    public Iterable<Acquisition> getAcquisitions() {
        return acquisitions;
    }

    public void setAcquisitions(Iterable<Acquisition> acquisitions) {
        this.acquisitions = acquisitions;
    }

    @Inject
    Iterable<Acquisition> acquisitions;

    @Inject
    Core core;



    public void showPlugins() {
        System.out.println("Plugins:");
        
        for(Acquisition a:acquisitions) {
            System.out.print("Plugin: ");
            System.out.println(a.getRoot());
        }
    }


}
