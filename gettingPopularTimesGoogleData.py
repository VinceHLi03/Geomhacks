#Stripping tool used is open source code found on GitHub: https://github.com/m-wrzr/populartimes
import populartimes
file = open("popularTimesData.txt", "w")

def getTimes(location, event):
    file.write(event + ": \n")
    for i in range(7):
        busytimes = location[i].get("data")
        busyString = ""

        for j in range(24):
            if (j == 23):
                busyString += str(busytimes[j]) + "\n"
            else:
                busyString += str(busytimes[j]) + " "

        file.write(busyString)

supermarket = populartimes.get_id("AIzaSyBeDXoRG4AHN8v_q5mhd5FZs-XxehrsXbc", "ChIJQ_Qwf9VCK4gRgiLkTszqEv0")
supermarket = supermarket.get("populartimes")
supermarketTimes = getTimes(supermarket, "Supermarket")

bank = populartimes.get_id("AIzaSyBeDXoRG4AHN8v_q5mhd5FZs-XxehrsXbc", "ChIJUU6mgkddK4gRti44O1Lze2Q")
bank = bank.get("populartimes")
bankTimes = getTimes(bank, "Bank")

pharmacy = populartimes.get_id("AIzaSyBeDXoRG4AHN8v_q5mhd5FZs-XxehrsXbc", "ChIJGZ-j11NDK4gRlhHS7708QXY")
pharmacy = pharmacy.get("populartimes")
pharmacyTimes = getTimes(pharmacy, "Pharmacy")



