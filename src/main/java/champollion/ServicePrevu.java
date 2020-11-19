package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
        private int volumeCM;
        private int volumeTD;
        private int volumeTP;
        private Enseignant e;
        private UE u;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP, Enseignant e, UE u) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.e = e;
        this.u = u;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public Enseignant getE() {
        return e;
    }

    public UE getU() {
        return u;
    }
    
    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    public void setE(Enseignant e) {
        this.e = e;
    }

    public void setU(UE u) {
        this.u = u;
    }
    
        
}
