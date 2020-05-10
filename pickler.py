import pandas as pd

object = pd.read_pickle(r'flag1.gme')
for i in object:
    print(i)
