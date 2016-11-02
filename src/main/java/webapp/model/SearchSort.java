package webapp.model;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public enum SearchSort {
    /// <summary>
    /// last_activity_date
    /// </summary>
    Activity,

    /// <summary>
    /// creation_date
    /// </summary>
    Creation,

    /// <summary>
    /// score
    /// </summary>
    Votes,

    /// <summary>
    /// matches the relevance tab on the site itself
    /// </summary>
    Relevance
}
