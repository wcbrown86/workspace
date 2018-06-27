class RockPaperScissors

  # Exceptions this class can raise:
  class NoSuchStrategyError < StandardError ; end
  LEGAL = ['R','S','P']
  def self.winner(player1, player2)
    # YOUR CODE HERE
    
    unless LEGAL.include?(player1[1]) && LEGAL.include?(player2[1])
    	raise NoSuchStrategyError, "Strategy must be one of R,P,S"
    end
   
    
    case player1[1]
    	when 'R'
    		if(player2[1] == 'P')
    			return player2
    		elsif(player2[1] == 'R')
    			return player1
    		else
    			return player1
    		end
    	when 'P'
    		if(player2[1] == 'S')
    			return player2
    		elsif(player2[1] == 'P')
    			return player1
    		else
    			return player1
    		end
     	when 'S'
    		if(player2[1] == 'R')
    			return player2
    		elsif(player2[1] == 'S')
    			return player1
    		else
    			return player1
    		end
    end
  end

  def self.tournament_winner(tournament)
    # YOUR CODE HERE
    if tournament[0][0].is_a? String
    	return winner(tournament[0], tournament[1])
    else
    	return winner(tournament_winner(tournament[0]), 			tournament_winner(tournament[1]))
    end
  end

end
