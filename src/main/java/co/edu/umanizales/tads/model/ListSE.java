package co.edu.umanizales.tads.model;

import co.edu.umanizales.tads.controller.dto.KidDTO;
import lombok.Data;

@Data
public class ListSE {
    private Node head;
    private int size;


    public void add(Kid kid) {
        if (head != null) {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            /// Para en el último
            Node newNode = new Node(kid);
            temp.setNext(newNode);
        } else {
            head = new Node(kid);
        }
        size++;
    }

    public void gainPositionKid(String id, int gain) {
        Node temp = head;
        gain = 0;
        int sun = 0;
        ListSE listSECp = new ListSE();
        if (head != null) {
            while (temp != null && !temp.getData().getIdentification().equals(id)) {
                listSECp.add(temp.getData());
            }
            temp.getNext();
        }
        sun = gain-getPosById(id);
        listSECp.addInpos(getKidByid(id),sun);
    }


    //get in pos by id
    public int getPosById(String id) {
        Node temp = head;
        int acun = 0;
        if (head != null) {
            while (temp != null && !temp.getData().getIdentification().equals(id)) {
                acun++;
                temp.getNext();
                return acun;

            }
        }
        return acun;
    }


    public void invert() {
        if (this.head != null) {
            ListSE listCp = new ListSE();
            Node temp = this.head;
            while (temp != null) {
                listCp.addToStart(temp.getData());
                temp = temp.getNext();
            }
            this.head = listCp.getHead();
        }
    }



    // 2 adicionar al inicio
    public void addToStart(Kid kid) {
        if (this.head != null) {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        } else {
            head = new Node(kid);
        }
        size++;

    }

    // 3 intercalar niño y niña
    public void IntercaleBoyandGirl() {
        ListSE listM = new ListSE();
        ListSE listF = new ListSE();
        Node temp = head;
        while (temp != null) {
            if (temp.getData().getGender() == 'm') {
            }
            listM.add(temp.getData());
        }
        if (temp.getData().getGender() == 'f') {
            listF.add(temp.getData());
        }
        temp = temp.getNext();

    }

    // eliminar por edad dada
    public void DeleteByAge(Byte age) {
        Node temp = head;

        ListSE listSE1 = new ListSE();
        //recorrer la lista original y crear la lista copia

        while (temp != null) {
            if (temp.getData().getAge() != age) {
                listSE1.addToStart(temp.getData());
                temp.getNext();

            }
        }
        this.head = listSE1.getHead();
    }

    //5 obtener el promediol promedio de edad de los ninos de la lista
    public float averageage() {
        if (head != null) {
            Node temp = head;
            int count = 0;
            int ages = 0;
            while (temp.getNext() != null) {
                count++;
                ages = ages + temp.getData().getAge();
                temp = temp.getNext();

            }
            return (float) ages / count;
        } else {
            return (int) 0;
        }
    }

    public void changeExtremes() {
        if (this.head != null && this.head.getNext() != null) {
            Node temp = this.head;
            while (temp.getNext() != null) {

                temp = temp.getNext();

            }

            //temp esta de ultimo
            Kid copy = this.head.getData();
            this.head.setData(temp.getData());
            temp.setData(copy);

        }
    }

    public void genderBoysToStart() {
        if (this.head != null) {
            ListSE listCp = new ListSE();
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().getGender() == 'M') {

                    listCp.addToStart(temp.getData());

                } else {
                    listCp.add(temp.getData());
                }
                temp = temp.getNext();
            }
            this.head = listCp.getHead();
        }
    }
    public  void LosePositionKid(String id,int lose){
        Node temp = head;
        lose = 0;
        int sum = 0;
        ListSE listSE1 = new ListSE();
        if (head != null){
            while (temp != null && !temp.getData().getIdentification().equals(id)){
                listSE1.add(temp.getData());
            }
        }
        sum = lose + getPosById(id);
        listSE1.addInpos(getKidByid(id), sum);

    }

    public int getCountKidsByLocationCode(String code) {
        int count = 0;
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().getLocation().getCode().equals(code)) {
                    count++;

                }
                temp = temp.getNext();

            }
        }
        return count;

    }

    public int verifyid(KidDTO kid) {
        Node temp = this.head;
        boolean found = false;
        while (temp != null) {
            if (temp.getData().getIdentification().equals(kid.getIdentification())) {
                found = true;
                break;
            }
            temp = temp.getNext();

        }
        return found ? 1 : 0;

    }


    //metodo para anadir nuevo nodo y nuevo nino en una posicion
    public void addInpos(Kid kid,int pos) {
        Node temp = head;
        for (int i = 0; 1 < pos;  i++) {
            temp = temp.getNext();
        }
        Node newNode = new Node(kid);
        temp.setNext(newNode);
    }

    // metodo para eliminar los ninos por id
    public void deleteByIdentification(String identification) {
        Node currentNode = head;
        Node prevNode = null;

        while (currentNode != null && currentNode.getData().getIdentification() != identification) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();

        }
        if (currentNode != null) {
            if (prevNode == null) {
                head = currentNode.getNext();

            } else {
                prevNode.setNext(currentNode.getNext());
            }
        }

    }

    // adelantar en posicion
    public void advanceInpos(Kid kid, int pos) {
        Node temp = head;
        for (int i = 0; 1 < pos; i++) {
            temp = temp.getNext();

        }
        Node newNode = new Node(kid);
        temp.setNext(newNode);

    }

    // anadir por posicion
    public void addbyposition(Kid kid, int position) {
        Node nuevoNodo = new Node(kid);
        if (position == 0) {
            nuevoNodo.setNext(head);
            head = nuevoNodo;

        } else {
            Node actual = head;
            for (int i = 1; 1 < position - 1 ;
            i++){
                actual = actual.getNext();

            }
            nuevoNodo.setNext(actual.getNext());
            actual.setNext(nuevoNodo);
        }
    }


    public Kid getKidByid(String id) {
        Node temp = head;
        if (head != null) {
            while (temp != null) {
                temp.getNext();
                while (!temp.getData().getIdentification().equals(id)) {
                    temp.getNext();
                }
                temp.getData();

            }
        }
        Kid kid =new Kid(temp.getData().getIdentification(),temp.getData().getName(),temp.getData().getAge());
        return kid;

    }



    public int getCountKidsBylocationAndGenderM(String code){
        int count=0;
        int countm=0;
        int countf=0;

        if(this.head !=null){
            Node temp = this.head;
            while (temp != null){
                if(temp.getData().getLocation().getCode().equals(code)){
                    count ++;
                    if (temp.getData().getGender()== 'M'){
                        countm++;
                    }
                }
            }
            temp=temp.getNext();
        }
        return countm;
    }
    public int getCountKidsBylocationAndGenderF(String code){
        int count=0;
        int countm=0;
        int countf=0;

        if(this.head !=null){
            Node temp = this.head;
            while (temp != null){
                if(temp.getData().getLocation().getCode().equals(code)){
                    count ++;
                }
            }
            temp=temp.getNext();
        }
        return countf;
    }
}








