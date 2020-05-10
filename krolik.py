krolikArray = ["kroliks", "go", "heaven.", "All", "to"]
FileName = input("Enter your first name my krolik: ")
Save = open("%s's file.txt" % (FileName), 'w')
Save.write('%s %s and kicias %s %s %s' %(krolikArray[3], krolikArray[0], krolikArray[1], krolikArray[4], krolikArray[2]))
Save.close()


