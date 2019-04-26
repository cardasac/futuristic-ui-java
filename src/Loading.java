public interface Loading
{
	void render();

	void update();

	int return_timer();

	Boolean check_finish(int timer);
}
