class Dessert

attr_accessor :name
attr_accessor :calories

  def initialize(name, calories)
    # your code here
    @name = name
    @calories = calories
    
  end
  def healthy?
    # your code here
    return calories < 200
    
  end
  def delicious?
    # your code here
    return true
    
  end
end

class JellyBean < Dessert

attr_accessor :flavor
  def initialize(flavor)
    # your code here
    @flavor = flavor
    @calories = 5
    @name = "#{flavor} jelly bean"
    
  end
  
  def delicious?
  	
  	if @flavor == "licorice"
  		return false
  	else
  		return true
  	end
  end
end
