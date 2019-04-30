public interface Loading
{
	void render();

	void update();

	int returnTimer();

	Boolean checkFinish(int timer);
}
