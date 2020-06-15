    package com.company;
    import java.util.*;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //given some events and their priority and lengths, make some objects
            // while the input is not equal to "finish"
            String n = br.readLine();
            int eventNums = Integer.parseInt(n);
            Event[] events = new Event[eventNums];

            String line = " ";
            for (int i = 0; i < eventNums; i++){
                System.out.println("Input the event name, it's priority, it's length");
                line = br.readLine();
                String[] inputs = line.split(" ");
                String name = inputs[0];
                int p = Integer.parseInt(inputs[1]);
                int l = Integer.parseInt(inputs[2]);
                int s = Integer.parseInt(inputs[3]);
                int e = Integer.parseInt(inputs[4]);
                events[i] = new Event(p,l,name,s,e);
            }

            //sorting the events based on their priorities
            events = sortedPrio(events);
            for (int i = 0; i < eventNums; i++){
                int p = events[i].getPrio();
                int l = events[i].getLength();
                String nme = events[i].getName();
                System.out.println(nme + " " + p);
            }

            // input the period of time that you are available, and then make a schedule from the sorted events
            int start, end;
            System.out.println("Please input the start and then the end of a time block");
            String times = br.readLine();
            String[] inputs = times.split(" ");
            start = Integer.parseInt(inputs[0]);
            end = Integer.parseInt(inputs[1]);

            Set<Integer> available = new HashSet<Integer>();

            for (int i = start; i<= end; i++){
                available.add(i);
            }

            int cur = start;
            for (int i = 0; i < eventNums; i++){
                if (available.isEmpty()){
                    System.out.println("Move the rest to tmrw for safety");
                    break;
                }
                Event temp = events[i];
                int time = temp.getLength();
                //find a time slot of length time

                int l = start;
                int r = start;
                int len = 0;

                while (len != time){
                    if (!available.contains(r) && (r > events[i].fEnd || r < events[i].fStrt)) {
                        l = r;
                        r++;
                        continue;
                    }
                    len = r - l;
                }
                System.out.println(events[i].name + " " + l + ":00 to " + r + ":00");
                for (int k = l; k <=r; k++){
                    available.remove(k);
                }
            }

        }

        public static Event[] sortedPrio(Event[] e){
            int sz = e.length;
            for (int i = 1; i < sz; i++){
                int key = e[i].getPrio();
                Event newEv = e[i];
                int j = i -1;

                while(j >= 0 && e[j].getPrio() > newEv.getPrio()){
                    e[j+1] = e[j];
                    j = j -1;
                }
                e[j+1] = newEv;
            }
            return e;
        }
    }

