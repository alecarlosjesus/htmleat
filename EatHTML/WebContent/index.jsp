<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

		<div>
			<form action="tasty" method="post">
				<fieldset>
					<legend>PUT THE NAME OF CHARACTER</legend>
					<div>
						<label>Name</label><br/>
						<input type="text" name="character" required id="character" placeholder="Type the name of Chacter"/>
					</div>
					<div>
						<input type="submit" id="btnSubmit" value="SEND"/>
					</div>					
				</fieldset>
			</form>
		</div>
		
		<div>
		
			${mainStream}
			
		</div>
