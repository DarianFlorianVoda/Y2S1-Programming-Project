package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
            //TEST without using Files
//        Car c1 = new Car("TZ19EQA", Customer.Subscribed, Cartype.Bus);
//        ArrayList<Car> cars1 = new ArrayList<>();
//        cars1.add(c1);
//        ArrayList<String> ent1 = new ArrayList<String>();
//        ArrayList<String> ext1 = new ArrayList<String>();
//        ent1.add("19.10.2020 19:40:40");
//        ext1.add("19.10.2020 19:50:50");
//        Parkentrance pe1 = new Parkentrance(cars1,ent1,ext1);
//        Parkinglot p1 = new Parkinglot(pe1, pz1);
//        Parkingchain.add(p1);
//        for(Parkinglot p: Parkingchain) {
//            System.out.println(p);
//        }

        //Creating the file "Parking_Chain" - I used the same code for creating "Parkings.txt" in order to not repeat the code.

        try {
            File myObj = new File("Parking_Chain.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //@strLine - variable that reads each line
        //@str_data - variable that contains all the data

        String strLine = "";
        String str_data = "";

        //Function that reads all the data and stores it in one variable

        try {
            BufferedReader br = new BufferedReader(new FileReader("Parkings.txt"));
            while (strLine != null) {
                if (strLine == null)
                    break;
                str_data += strLine;
                strLine = br.readLine();

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }

        //@all_data - stored all the data on EACH PARKING LOT.
        //@Parkingchain - ArrayList that stores All the Parking Lots but as Objects!
        //@list_parkzones - ArrayList of all the parkzones
        //@list_cars - ArrayList of all the cars
        //@list_entrances - ArrayList of all the entrances

        String[] all_data = str_data.split("-");
        List<Parkinglot> Parkingchain = new ArrayList<>();
        ArrayList<Parkzone> list_parkzones = new ArrayList<>();
        ArrayList<Car> list_cars = new ArrayList<>();
        ArrayList<Parkentrance> list_entrances = new ArrayList<>();

        //A For that goes through all the data and configures the data

        for (String e : all_data) {

            //@each_line - stores all the data from each line separating all the data with ";"
            //@types - gets the first line which is about: 1. Number of Parking zones, 2. Number of cars, 3. Number of entrances

            String[] each_line = e.split(";");
            String[] types = each_line[0].split(" ");

            //A For loop that iterates through the zones and puts the information into list_parkzones

            for (int zones = 1; zones <= Integer.parseInt(types[0]); zones++) {
                String zone_types = each_line[zones];
                String[] explicit_types = zone_types.split(",");
                Cartype parkzone_cartype = null;

                //@zone_types - string that retains the index of the element from each line
                //@explicit_types - retains the elements of a parking zone: space (explicit_types[0]) and type(explicit_types[1]).

                if (explicit_types[1].equals("Bus"))
                    parkzone_cartype = Cartype.Bus;
                if (explicit_types[1].equals("Small_car"))
                    parkzone_cartype = Cartype.Small_car;
                if (explicit_types[1].equals("Big_car"))
                    parkzone_cartype = Cartype.Big_car;
                if (explicit_types[1].equals("Extreme_big_car"))
                    parkzone_cartype = Cartype.Extreme_big_car;

                //@Parkzone_spaces - # of spaces

                int Parkzone_spaces = Integer.parseInt(explicit_types[0]);
                Parkzone parkzone = new Parkzone(Parkzone_spaces, parkzone_cartype);
                list_parkzones.add(parkzone);
            }

            //for loop that iterates for each cars that are listed in the text file

            for (int cars_number = 1; cars_number <= Integer.parseInt(types[1]); cars_number++) {

                //@cars_types - a string that retains the string of only the cars
                //@explicit_cars - the elements needed for the cars splitted by ",";
                //@carplate - the plate of the car
                //@payment - the type of the payment that customer has
                //@parkzone_cartype - the type of the car for the parkzone

                String cars_types = each_line[cars_number + Integer.parseInt(types[0])];
                String[] explicit_cars = cars_types.split(",");
                String carplate = explicit_cars[0];
                Customer payment = null;
                if (explicit_cars[1].equals("Subscribed"))
                    payment = Customer.Subscribed;
                if (explicit_cars[1].equals("Ocasionally"))
                    payment = Customer.Ocasionally;
                Cartype parkzone_cartype = null;
                if (explicit_cars[2].equals("Bus"))
                    parkzone_cartype = Cartype.Bus;
                if (explicit_cars[2].equals("Small_car"))
                    parkzone_cartype = Cartype.Small_car;
                if (explicit_cars[2].equals("Big_car"))
                    parkzone_cartype = Cartype.Big_car;
                if (explicit_cars[2].equals("Extreme_big_car"))
                    parkzone_cartype = Cartype.Extreme_big_car;
                Car car = new Car(carplate, payment, parkzone_cartype);
                list_cars.add(car);

            }

            //A for loop that iterates through all the entrances

            for (int entrances_number = 1; entrances_number <= Integer.parseInt(types[2]); entrances_number++) {

                //@entrances_types - the string with only just entrances
                //@each_entrance - info about each entrance on one line splitted by "/"
                //@explicit_entrance - info about one entrance explicitly
                //@entrance_car - info about the list of the cars at the entrance
                //@entry_timers - info about the list of the entry times for the cars
                //@exit_timers - info about the list of the exit times for the cars

                String entrances_types = each_line[entrances_number + Integer.parseInt(types[0]) + Integer.parseInt(types[1])];
                String[] each_entrance = entrances_types.split("/");
                String[] explicit_entrance;
                ArrayList<Car> entrance_car = new ArrayList<>();
                ArrayList<String> entry_timers = new ArrayList<>();
                ArrayList<String> exit_timers = new ArrayList<>();

                //@carplate_ent - the car plate of the car
                //@entry_time - the entry time for one car
                //@exit_time - the exit time for one car

                for (int explicity_of_entrance = 0; explicity_of_entrance < each_entrance.length; explicity_of_entrance++) {
                    explicit_entrance = each_entrance[explicity_of_entrance].split(",");
                    Car carplate_ent = new Car();
                    carplate_ent.setCarnumber(explicit_entrance[0]);
                    if (carplate_ent.getCarnumber().equals("0")) {
                        carplate_ent.setCarnumber("");
                        String entry_time = "";
                        String exit_time = "";
                    } else {
                        String entry_time = explicit_entrance[1];
                        String exit_time = explicit_entrance[2];
                        entrance_car.add(carplate_ent);
                        entry_timers.add(entry_time);
                        exit_timers.add(exit_time);
                        for(Car every_car: list_cars)
                        {
                            if (carplate_ent.getCarnumber().equals(every_car.getCarnumber()))
                            {
                                carplate_ent.setCartype(every_car.getCartype());
                                carplate_ent.setCustype(every_car.getCustype());
                            }
                        }
                    }
                }
                Parkentrance parkentrance = new Parkentrance(entrance_car, entry_timers, exit_timers);
                list_entrances.add(parkentrance);
            }
            Parkinglot Parking_lot = new Parkinglot(list_entrances,list_parkzones);
            Parkingchain.add(Parking_lot);

        }

        //Writing the file on Parking_Chain.txt

        try {
            FileWriter myWriter = new FileWriter("Parking_Chain.txt");
            for(Parkinglot Parkings: Parkingchain)
            {
                myWriter.write(String.valueOf(Parkings));
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }

        //Showing the occupancy rate for each parking lot

        double occupancy_rate;
        for(Parkinglot Parks: Parkingchain)
        {   int nr_entrances = Parks.getnrEntrances();
            int nr_spaces = Parks.getnrSpaces();
            occupancy_rate = (double)nr_entrances/nr_spaces*100;
            System.out.printf("%.2f",occupancy_rate);
            System.out.println("%");
        }

        //Giving a discount for the cars that parked more than 10 times

        ArrayList<String> discounted_cars = new ArrayList<>();
        for(Parkentrance all_cars: list_entrances) {
            for (Car verify_discount : all_cars.getCar()) {
                int k = 0;
                int total_parkings = 1;
                for (Car verify_discount2 : all_cars.getCar()) {
                    if (verify_discount.getCarnumber().equals(verify_discount2.getCarnumber()))
                        k++;
                    if (k == 1)
                        continue;
                    else if (k > 1)
                        total_parkings++;
                }
                if (total_parkings == 10) {
                    if(discounted_cars.contains(verify_discount.getCarnumber()))
                        continue;
                    else {
                        System.out.println(verify_discount.getCarnumber() + " Has a discount!");
                        discounted_cars.add(verify_discount.getCarnumber());
                    }
                } else
                if(discounted_cars.contains(verify_discount.getCarnumber()))
                    System.out.println(verify_discount.getCarnumber() + " Has a discount!");
                else
                    System.out.println(verify_discount.getCarnumber() + " Does not have a discount!");
            }
        }

        //Computing the gain of the day based on all the parking lots

        double all_sum = 0;
        double subs_sum = 0;
        double ocasionally_sum = 0;
        for(Parkentrance testcars: list_entrances)
        {
            for(Car allcars: testcars.getCar())
            {
                if(allcars.getCustype().equals(Customer.Ocasionally))
                {   if(discounted_cars.contains(allcars.getCarnumber()))
                        ocasionally_sum = ocasionally_sum + 2.5;
                    else
                        ocasionally_sum = ocasionally_sum + 3;
                }
                if(allcars.getCustype().equals(Customer.Subscribed))
                {
                    subs_sum = subs_sum + 2;
                }
            }
            all_sum = ocasionally_sum + subs_sum;
        }

        System.out.println("Total gain of parking lots: " + all_sum);
        System.out.println("Total gain of subscribes: " + subs_sum);
        System.out.println("Total gain of ocasionally parks: " + ocasionally_sum);


        //Saving the file into HDD

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Parking_Chain.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Parkingchain);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Data was saved to HDD.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Loading the file

        try {
            FileInputStream fileInputStream = new FileInputStream("Parking_Chain.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Parkinglot> ParkingCein = (ArrayList<Parkinglot>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

