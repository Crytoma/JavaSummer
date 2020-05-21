letter  = input("Give me a letter to check: ")
def vowel():
    all_vowels = 'auiou'
    if letter in all_vowels:
        print(letter, " is is a vowel")
    else:
        print(letter, " is not a vowel")

vowel()