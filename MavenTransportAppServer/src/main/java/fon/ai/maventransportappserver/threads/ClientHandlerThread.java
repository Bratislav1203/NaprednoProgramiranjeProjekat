package fon.ai.maventransportappserver.threads;

import fon.ai.maventransportappserver.controller.Controller;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import fon.ai.maventransportappcommon.transfer.RequestObject;
import fon.ai.maventransportappcommon.transfer.ResponseObject;
import fon.ai.maventransportappcommon.util.Operation;
import fon.ai.maventransportappcommon.util.ResponseStatus;

/**
 *
 * @author stackOverflow
 */
public class ClientHandlerThread extends Thread{
    private Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream oos;

    public ClientHandlerThread(Socket socket) throws IOException{
        this.socket = socket;
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());        
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            RequestObject request;
            ResponseObject response = new ResponseObject();
            try {
            
                try{
                    request = receiveRequest();
                }catch(Exception ex){
                    socket.close(); 
                    System.out.println("Klijent se odjavio");
                    return;
                }

                switch (request.getOperation()) {
                    case Operation.SAVE_DRIVER:
                        try {
                                Controller.getController().zapamtiVozaca((IGeneralEntity) request.getData());
                                response.setStatus(ResponseStatus.SUCCESS);
                            } catch (Exception e) {
                                response.setStatus(ResponseStatus.ERROR);
                                response.setException(e);
                            }
                            sendResponse(response);
                        break;
                    case Operation.LOGIN:
                        try{
                            IGeneralEntity objekat = Controller.getController().pronadjiKorisnika((IGeneralEntity)request.getData());           
                            response.setData(objekat);
                            response.setStatus(ResponseStatus.SUCCESS);
                        }catch(Exception e){
                            response.setException(e);
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        sendResponse(response);
                        break;
                    case Operation.SAVE_TRUCK:
                        try{
                            Controller.getController().zapamtiKamion((IGeneralEntity)request.getData());           
                            response.setStatus(ResponseStatus.SUCCESS);
                        }catch(Exception e){
                            response.setException(e);
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        sendResponse(response);
                        break;
                        
                    case Operation.SAVE_TRAILER:
                        try{
                            Controller.getController().zapamtiPrikolicu((IGeneralEntity)request.getData());           
                            response.setStatus(ResponseStatus.SUCCESS);
                        }catch(Exception e){
                            response.setException(e);
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        sendResponse(response);
                        break;
                        
                    case Operation.VRATI_VOZACE:
                        try {
                            List<IGeneralEntity> entity = Controller.getController().vratiVozace();
                            response.setStatus(ResponseStatus.SUCCESS);
                            response.setData(entity);
                        } catch (Exception e) {
                            response.setStatus(ResponseStatus.ERROR);
                            response.setException(e);
                        }
                        sendResponse(response);
                        break;
                    case Operation.TAKE_TRUCKS:
                        try {
                            List<IGeneralEntity> entity = Controller.getController().vratiVozila();
                            response.setStatus(ResponseStatus.SUCCESS);
                            response.setData(entity);
                        } catch (Exception e) {
                            response.setStatus(ResponseStatus.ERROR);
                            response.setException(e);
                        }
                        sendResponse(response);
                        break;
                        
                    case Operation.TAKE_TRAILERS:
                        try {
                            List<IGeneralEntity> entity = Controller.getController().vratiPrikolice();
                            response.setStatus(ResponseStatus.SUCCESS);
                            response.setData(entity);
                        } catch (Exception e) {
                            response.setStatus(ResponseStatus.ERROR);
                            response.setException(e);
                        }
                        sendResponse(response);
                        break;
                        
                    case Operation.SAVE_DRIVE:
                        try{
                            Controller.getController().zapamtiVoznju((IGeneralEntity)request.getData());           
                            response.setStatus(ResponseStatus.SUCCESS);
                        }catch(Exception e){
                            response.setException(e);
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        sendResponse(response);
                    break;
                    case Operation.TAKE_DRIVES:
                        try {
                            List<IGeneralEntity> entity = Controller.getController().vratiVoznje();
                            response.setStatus(ResponseStatus.SUCCESS);
                            response.setData(entity);
                        } catch (Exception e) {
                            response.setStatus(ResponseStatus.ERROR);
                            response.setException(e);
                        }
                        sendResponse(response);
                        break;
                    case Operation.DELETE_DRIVE:
                        try{
                            Controller.getController().obrisiVoznju((IGeneralEntity)request.getData());           
                            response.setStatus(ResponseStatus.SUCCESS);
                        }catch(Exception e){
                            response.setException(e);
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        sendResponse(response);
                        break;
                        
                        case Operation.TAKE_DRIVE_BY_ID:
                        try{
                            IGeneralEntity objekat = Controller.getController().vratiVoznjuPoIDu((IGeneralEntity)request.getData());           
                            response.setData(objekat);
                            response.setStatus(ResponseStatus.SUCCESS);
                        }catch(Exception e){
                            response.setException(e);
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        sendResponse(response);
                        break;
                        case Operation.UPDATE_DRIVE:
                        try{
                            Controller.getController().updateDrive((IGeneralEntity)request.getData());           
                            response.setStatus(ResponseStatus.SUCCESS);
                        }catch(Exception e){
                            response.setException(e);
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        sendResponse(response);
                    break;
                    case Operation.TAKE_COST:
                        try {
                            List<IGeneralEntity> entity = Controller.getController().vratiTroskovePoIDu();
                            response.setStatus(ResponseStatus.SUCCESS);
                            response.setData(entity);
                        } catch (Exception e) {
                            response.setStatus(ResponseStatus.ERROR);
                            response.setException(e);
                        }
                        sendResponse(response);
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public RequestObject receiveRequest() throws IOException, ClassNotFoundException {
        return (RequestObject) in.readObject();
    }
    
    public void sendResponse(ResponseObject ro) throws IOException{
        oos.flush();
        oos.writeObject(ro);
    }
}
