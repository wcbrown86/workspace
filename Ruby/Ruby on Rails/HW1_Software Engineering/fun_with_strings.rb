module FunWithStrings
  def palindrome?
    # your code here
    str = self.downcase.gsub(/[^\p{Alnum}]/,'')
    str == str.reverse
  end
  def count_words
    # your code here
    string_hash = Hash.new(0)
    str = self.downcase.gsub(/[^\p{Alnum}]/,' ').split(" ")
    str.each { |x| string_hash[x] += 1}
   
    return string_hash
  end
  def anagram_groups
    # your code here
    str = self.split(" ")
    return str.group_by { |x| x.downcase.chars.sort}.values
  end
end

# make all the above functions available as instance methods on Strings:

class String
  include FunWithStrings
end
