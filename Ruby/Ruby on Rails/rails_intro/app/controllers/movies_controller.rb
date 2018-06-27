class MoviesController < ApplicationController

  def show
    id = params[:id] # retrieve movie ID from URI route
    @movie = Movie.find(id) # look up movie by unique ID
    # will render app/views/movies/show.<extension> by default
  end

  def index
    @all_ratings = Movie.all_ratings
    if(!params[:ratings].nil? and params[:ratings] != session[:ratings])
      @ratings = params[:ratings]
      session[:ratings] = params[:ratings]
    else
      @ratings = session[:ratings]
    end
    
    if(!params[:sort_by].nil? and params[:sort_by] != session[:ratings])
      @sort_by = params[:sort_by]
      session[:sort_by] = params[:sort_by]
    else
      @sort_by = session[:sort_by]
    end
    
    
    if (@sort_by.nil? and @ratings.nil?)
      @movies = Movie.all
    elsif (@ratings.nil?)

      begin
        @movies = Movie.order("#{@sort_by} ASC").all
      end
    elsif (@sort_by.nil?)
     
      begin
        @movies = Movie.find_all_by_rating(@ratings.keys)
      end
    else

      begin
        @movies = Movie.order("#{@sort_by} ASC").find_all_by_rating(@ratings.keys)
      end
    end
  end

  def new
    # default: render 'new' template
  end

  def create
    @movie = Movie.create!(params[:movie])
    flash[:notice] = "#{@movie.title} was successfully created."
    redirect_to movies_path
  end

  def edit
    @movie = Movie.find params[:id]
  end

  def update
    @movie = Movie.find params[:id]
    @movie.update_attributes!(params[:movie])
    flash[:notice] = "#{@movie.title} was successfully updated."
    redirect_to movie_path(@movie)
  end

  def destroy
    @movie = Movie.find(params[:id])
    @movie.destroy
    flash[:notice] = "Movie '#{@movie.title}' deleted."
    redirect_to movies_path
  end

end
