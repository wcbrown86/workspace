//Solution goes in Sources

class Year {

    public var isLeapYear: Bool
    
    init(calendarYear: Int){
        isLeapYear = false    
        if(calendarYear % 4 == 0){
            if(calendarYear % 100 != 0 || calendarYear % 400 == 0){
                isLeapYear = true
            }
        }
    }
}