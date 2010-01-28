package at.tuwien.ifs.hoppla.acquisition;

import javax.inject.Named;

/**
 * @author Michael Greifeneder - greifeneder@ifs.tuwien.ac.at
 */
public class SSHAcquisition implements Acquisition {

    public String getRoot() {
        return "SSH";
    }
}
