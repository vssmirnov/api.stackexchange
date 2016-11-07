package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Model SearchSort from site of http://api.stackexchange.com</p>
 */
public enum SearchSort {
    /// <summary>
    /// last_activity_date
    /// </summary>
    activity,

    /// <summary>
    /// creation_date
    /// </summary>
    creation,

    /// <summary>
    /// score
    /// </summary>
    votes,

    /// <summary>
    /// matches the relevance tab on the site itself
    /// </summary>
    relevance
}
