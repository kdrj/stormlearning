import storm

class SplitSenetenceBolt(storm.BasicBolt):
    def process(self,tup):
        words=tup.values[0].split(" ")
        for word in words:
            storm.emit([word])
SplitSenetenceBolt.run()