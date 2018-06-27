using UnityEngine;
using System.Collections;

public class AIScript_WilliamBrown : MonoBehaviour {

    public CharacterScript mainScript;

    public float[] bombSpeeds;
    public float[] buttonCooldowns;
    public float playerSpeed;
    public int[] beltDirections;
    public float[] buttonLocations;
	public int timeCount;
	public int wait = 60;
	public bool movingUp;
	float playerLocation;

	// Use this for initialization
	void Start () {
        mainScript = GetComponent<CharacterScript>();

        if (mainScript == null)
        {
            print("No CharacterScript found on " + gameObject.name);
            this.enabled = false;
        }

        buttonLocations = mainScript.getButtonLocations();


        playerSpeed = mainScript.getPlayerSpeed();
		timeCount = 0;
		movingUp = true; 
		playerLocation = 0;
	}

	// Update is called once per frame
	void Update () {

        buttonCooldowns = mainScript.getButtonCooldowns();
        beltDirections = mainScript.getBeltDirections();
		bombSpeeds = mainScript.getBombSpeeds();
		playerLocation = mainScript.getCharacterLocation ();
		 
        //Your AI code goes here

		if (playerLocation < 9.0f && playerLocation > 3.0f && timeCount == 0) {

			mainScript.moveDown ();
			mainScript.push ();
			timeCount = wait;
			movingUp = false;

		} else if (playerLocation < 3.0f && playerLocation > -3.0f && timeCount == 0) {

			huristicPickedDirection ();
			timeCount = wait;
			print (movingUp);

		} else if (playerLocation < -3.0f && playerLocation > -9.0f && timeCount == 0) {

			mainScript.moveUp ();
			mainScript.push ();
			timeCount = wait;
			movingUp = true;

		} else {
			if (movingUp) {
				mainScript.moveUp ();
				mainScript.push ();
			} else {
				mainScript.moveDown ();
				mainScript.push ();
			}
		}

		timeCount = timeCount - 1;

	}

	void huristicPickedDirection(){

		float moveUp = 0;
		float moveDown = 0;

		for (int i = 0; i < beltDirections.Length; i++) {

			if (i > 4) {
				if (beltDirections [i] == -1 && buttonCooldowns[i] <= 0) {
					moveUp = moveUp + Mathf.Abs(buttonLocations [i] + bombSpeeds[i]);
				}
			} else if(i <= 4  && beltDirections[i] == -1) {
				if (beltDirections [i] == -1 && buttonCooldowns[i] <= 0) {
					moveDown = moveDown + Mathf.Abs(buttonLocations [i] + bombSpeeds[i]);
				}
			}


		}

		if (moveUp > moveDown) {
			mainScript.moveUp ();
			mainScript.push ();
			movingUp = true;
		} else if (moveUp < moveDown) {
			mainScript.moveDown ();
			mainScript.push ();
			movingUp = false;
		} else {
			pickRandomDirection ();
		}

		print ("MoveUp " + moveUp);
		print ("MoveDown " + moveDown);
	}

	void pickRandomDirection(){

		int rand = Random.Range (0, 100);

		if (rand % 2 == 0) {
			mainScript.moveDown ();
			mainScript.push ();
			movingUp = false;

		} else {
			mainScript.moveUp ();
			mainScript.push ();
			movingUp = true;
		}
	}
}
