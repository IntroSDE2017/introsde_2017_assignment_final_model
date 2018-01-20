package introsde.APP1.parks.endpoint;

import javax.xml.ws.Endpoint;

import introsde.APP1.parks.soap.ParkImpl;


//Endpoint publisher
public class ParkPublisher{
    public static void main(String[] args) {
       Endpoint.publish("http://localhost:6900/app1/park", new ParkImpl());
    }
}