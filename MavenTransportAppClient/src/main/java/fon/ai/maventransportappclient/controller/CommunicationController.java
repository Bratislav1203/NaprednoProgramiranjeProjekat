package fon.ai.maventransportappclient.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fon.ai.maventransportappclient.client.forms.FDrivesSearch;
import fon.ai.maventransportappclient.client.forms.FMainForm;
import fon.ai.maventransportappclient.sesija.BuildGson;
import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.CostList;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappcommon.domain.Vehicle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import fon.ai.maventransportappclient.sesija.Sesija;
import fon.ai.maventransportappcommon.domain.VehicleType;
import fon.ai.maventransportappcommon.transfer.RequestObject;
import fon.ai.maventransportappcommon.transfer.ResponseObject;
import fon.ai.maventransportappcommon.util.Operation;
import fon.ai.maventransportappcommon.util.ResponseStatus;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommunicationController {
    private static CommunicationController instance;
    private Socket socket;
    private CostList costList;
    private FMainForm fmf;
    ArrayList<CostItem> costs;

    private CommunicationController() throws IOException {
        socket = new Socket("localhost", 9000);
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        Sesija.getSesija().setSocket(socket);
        Sesija.getSesija().setOos(outSocket);
        Sesija.getSesija().setOis(inSocket);
        System.out.println("Klijent se povezao");
    }
    
    public static CommunicationController getInstance() throws IOException {
        if(instance == null)
            instance = new CommunicationController();
        return instance;
    }

    public static void setInstance(CommunicationController aInstance) {
        instance = aInstance;
    }


    public CommunicationController(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private void sendRequest(RequestObject request) throws Exception {
        try{
            Sesija.getSesija().getOos().flush();
            Sesija.getSesija().getOos().writeObject(request);
        }catch(IOException ex){
            JOptionPane.showMessageDialog(fmf, "Server je pao, odjavicemo vas nalog. Pokusajte kasnije!");
            System.exit(0);
        }
    }
    
        private ResponseObject receiveResponse() throws IOException, ClassNotFoundException {
        ResponseObject response = (ResponseObject) Sesija.getSesija().getOis().readObject();
        return response;
    }

    
    public Object saveVehicle(Vehicle v) throws IOException, ClassNotFoundException, Exception {
        RequestObject request = new RequestObject();
        request.setData(v);
        request.setOperation(Operation.SAVE_VEHICLE);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (Vehicle) response.getData();
        
    }

       public User login(User user) throws Exception{
        RequestObject request = new RequestObject();
        request.setData(user);
        request.setOperation(Operation.LOGIN);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.SUCCESS){
            return (User)response.getData();
        }else{
            throw response.getException();
        }
        
    }

    public void insertDriver(Driver d) throws Exception {
        RequestObject request = new RequestObject();
        request.setData(d);
        request.setOperation(Operation.SAVE_DRIVER);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw response.getException();
        }
    }

    public void insertTruck(Vehicle truck) throws Exception {
        RequestObject request = new RequestObject();
        request.setData(truck);
        request.setOperation(Operation.SAVE_TRUCK);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw response.getException();
        }
    }

    public void insertTrailer(Vehicle trailer) throws Exception{
        RequestObject request = new RequestObject();
        request.setData(trailer);
        request.setOperation(Operation.SAVE_TRAILER);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw response.getException();
        }
    }

    public List<Driver> vratiVozace() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.VRATI_VOZACE);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
            return (List<Driver>) response.getData();
        } else {
            throw (Exception) response.getException();
        }
    }

    public List<Truck> vratiVozila() throws Exception{
        RequestObject request = new RequestObject();
        request.setOperation(Operation.TAKE_TRUCKS);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
            return (List<Truck>) response.getData();
        } else {
            throw (Exception) response.getException();
        }
    }

    public List<Trailer> vratiPrikolice() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.TAKE_TRAILERS);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
            return (List<Trailer>) response.getData();
        } else {
            throw (Exception) response.getException();
        }
    }

    public CostList getCostList() {
        return costList;
    }

    public void setCostList(CostList costList) {
        this.costList = costList;
    }

    public void insertDrive(Drive d) throws Exception {
        RequestObject request = new RequestObject();
        request.setData(d);
        request.setOperation(Operation.SAVE_DRIVE);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw response.getException();
        }
    }

    public List<Drive> vratiVoznje() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.TAKE_DRIVES);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
            return (List<Drive>) response.getData();
        } else {
            throw (Exception) response.getException();
        }
    }

    public void deleteDrive(Drive d) throws Exception{
        RequestObject request = new RequestObject();
        request.setData(d);
        request.setOperation(Operation.DELETE_DRIVE);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw response.getException();
        }
    }
    
    public void deleteCostList(CostList cl) throws Exception{
        RequestObject request = new RequestObject();
        request.setData(cl);
        request.setOperation(Operation.DELETE_COST_LIST);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw response.getException();
        }
    }

    public void deleteCostItem(CostItem c) throws Exception{
        RequestObject request = new RequestObject();
        request.setData(c);
        request.setOperation(Operation.DELETE_COST_ITEM);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw response.getException();
        }
    }

    public Drive vratiVoznjuPoIDu(Drive d)throws Exception {
        RequestObject request = new RequestObject();
        request.setData(d);
        request.setOperation(Operation.TAKE_DRIVE_BY_ID);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.SUCCESS){
            return (Drive)response.getData();
        }else{
            throw response.getException();
        }
    }

   public void updateDrive(Drive drive) throws Exception {
        RequestObject request = new RequestObject();
        request.setData(drive);
        request.setOperation(Operation.UPDATE_DRIVE);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw response.getException();
        }
    }
   
   public void updateCostItem(CostItem costItem) throws Exception {
       RequestObject request = new RequestObject();
       request.setData(costItem);
       request.setOperation(Operation.UPDATE_COST_ITEM);
       sendRequest(request);
       ResponseObject response = receiveResponse();
       if(response.getStatus() == ResponseStatus.ERROR){
           throw response.getException();
       }
   }

    public void setCosts(ArrayList<CostItem> costs) {
        this.costs = costs;
    }

    public ArrayList<CostItem> getCosts() {
        return costs;
    }

    public ArrayList<CostItem> vratiTroskove() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.TAKE_COST);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if(response.getStatus() == ResponseStatus.SUCCESS){
            return (ArrayList<CostItem>)response.getData();
        }else{
            throw response.getException();
        }
    }

    public Drive importFromJSON() {
        throw new UnsupportedOperationException("ImportJson Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void prikaziDetalje(Drive drive) {
        throw new UnsupportedOperationException("prikaziDetalje Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void izveziUJson(Drive d) {
        try {
            Drive voznja = d;
            FileWriter fw = new FileWriter("voznja_br"+voznja.getId()+".json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            fw.write(gson.toJson(voznja));
            fw.close();
        } catch (Exception ex) {
            System.out.println("Nisam ispisao u JSON");
            Logger.getLogger(FDrivesSearch.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
    }

    public Drive deserijalizacijaJSON(String putanja) throws Exception{
        FileReader in = new FileReader(putanja);
        Gson gson = BuildGson.buildGson();;
        Drive voznja = gson.fromJson(in, Drive.class);
        in.close();
        return voznja;
    }
 
    
}